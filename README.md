# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID:** G00468865@atu.ie
**Examination group:** B (OpenFeign):  
**Original examination pull-request URL (`exam-work`):** https://github.com/Padra1c/G00468865-atu.ie/pull/1  
**New review repository URL:** https://github.com/Padra1c/CICD_Review_G00468865 

## 1. My original examination self-assessment

### Task 1 — /40
**My mark: 15**  
**Evidence from the original code (files, methods, working or missing requirements):** 
- The booking entity included an 'id', 'organiserName', 'roomId', no args constructor, 'BookingRepo' and extended my JpaRepository 
- '@NotBlank' was included in 'organiserName'
- An attendeeCount and status check was not included in my code
- id and roomId were given the same annotation
- Only 1 dto instead of 2 


### Task 2 — /40
**My mark: 2**  
**Evidence from the original code:** 
- No @FeignClient or @EnableFeignClients
- In BookingService, RoomRepository and the Room class were never initialised,
- findById() had no argument, if() was outside method
- POST had no endpoint and wasnt able to save bookings or check the capacity of rooms
- GET wasnt able to be tested


### Task 3 — /20
**My mark: 10**  
**Evidence from the original code:**
- getBooking in BookingController read from bookingRepo.findById(id) and used ResponseStatusException with NOT_FOUND and "Booking not found" when missing
- /api/booking was mapped instead of /api/bookings
- Didnt return DTO
- Project didnt compile 

**Total self-assessed original examination mark: 27/100**

## 2. Corrections and improvements in my new project


**Problem and correction 1:** I included 2 @Id annotations and both are missing fields. I changed booking to have a single @Id. I also added int attendeeCount and String status = ACTIVE. This corrected approach works because @Id is now a primary key, so the roomId wont be its identity. Also, with status, every new booking is ACTIVE

**Problem and correction 2:** I was reading room data using a repository instead of using OpenFeign. The correction was to add RoomClient that was annotated witn OpenFeign's @FeignClient that had @GetMapping("/api/rooms/{id}"), which this time returns a DTO. Also I added @EnableFeignClients to the main class. BookingService now calls roomClient.getRoom(...), rejects the request with 400 if attendeeCount is greater than the capacity 

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input:  POST http://localhost:8081/api/bookings. {"roomId":1,"organiserName":"Padraic O Loughlin","attendeeCount":3}
- Expected:  201, booking with status active
- Actual HTTP status / body:  201, bookingId 3, attendeeCount 3, roomId 1, status ACTIVE
- Pass / fail:  Pass

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  POST http://locahost:8081/api/bookings. {"roomId":1,"organiserName":"Padraic O Loughlin","attendeeCount":300}
- Expected:  400
- Actual HTTP status / body:  400, "attendeeCount exceeds room capacity of 24"
- Pass / fail:  Pass

- Request / input: POST http://localhost:8081/api/bookings. {"roomId":1,"organiserName":"P","attendeeCount":-3}
- Expected: 400
- Actual HTTP status / body: 400, "Validation failed for object='bookingRequest'. Error count: 2" (attendeeCount rejected value -3, failed @Positive)
- Result: Pass

**Test 4 — requirement specific to my group:**  
- Request / input:  POST http://localhost:8081/api/bookings. {"roomId":9999,"organiserName":"Padraic O Loughlin","attendeeCount":3}
- Expected:  404
- Actual HTTP status / body:  404, message "Room not found"
- Pass / fail:  Pass

## 4. Reflection

**What did I understand during the examination but struggle to implement?**  
I understood the basic project setup and memorised it to be Entity - Repository - DTO - Service and Controller. But once I had to link things such as the Repository to the correct service, I got confused. What exactly needed to be handled was an aspect i struggled with also, as I forgot error messages and coutless other key parts of the code.

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**  
Before the exam I thought that room data was able to be gotten from booking service, even if they are not on the same database. So the RoomRepository.findById() could never work since they are different programs on different ports. Now I know that OpenFeign can solve this by creating a method body, which sends data to the specific port, and converts the response to a DTO. The capacity message and room not found message both came from OpenFeign, which in my case was "capacity of 24"

**What will I do differently in my next coding test or API development task?**  
Further learn how the code communicates with OpenFeign and SpringBoot, to know how to manipulate structure depending on whats asked
## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**
