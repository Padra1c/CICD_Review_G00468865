package ie.atu.sample.service;

import feign.FeignException;
import ie.atu.sample.client.RoomClient;
import ie.atu.sample.dto.BookingRequest;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.dto.RoomDTO;
import ie.atu.sample.model.Booking;
import ie.atu.sample.repository.BookingRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final RoomClient roomClient;

    public BookingService(BookingRepo bookingRepo, RoomClient roomClient) {
        this.bookingRepo = bookingRepo;
        this.roomClient = roomClient;
    }

    public BookingResponse createBooking(BookingRequest request) {
        RoomDTO room;
        try {
            room = roomClient.getRoom(request.roomId());
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found");
        }

        if (request.attendeeCount() > room.capacity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Attendee count exceeds room capacity of " + room.capacity());
        }

        Booking booking = new Booking();
        booking.setOrganiserName(request.organiserName());
        booking.setAttendeeCount(request.attendeeCount());
        booking.setRoomId(request.roomId());

        return toResponse(bookingRepo.save(booking));
    }

    public BookingResponse getBooking(Long id) {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Booking not found"));
        return toResponse(booking);
    }

    private BookingResponse toResponse(Booking b) {
        return new BookingResponse(
                b.getId(), b.getOrganiserName(), b.getAttendeeCount(),
                b.getRoomId(), b.getStatus());
    }
}