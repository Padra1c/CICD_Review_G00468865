package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookingRequest(
        @NotNull(message = "roomId is required")
        Long roomId,

        @NotBlank(message = "organiserName must not be blank")
        @Size(min = 2, max = 60, message = "organiserName must be 2-60 characters")
        String organiserName,

        @NotNull(message = "attendeeCount is required")
        @Positive(message = "attendeeCount must be a positive number")
        Integer attendeeCount
) {}