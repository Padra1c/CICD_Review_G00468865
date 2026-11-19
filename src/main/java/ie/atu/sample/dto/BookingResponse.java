package ie.atu.sample.dto;

public record BookingResponse(
        Long bookingId,
        String organiserName,
        int attendeeCount,
        Long roomId,
        String status
) {}