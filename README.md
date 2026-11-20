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

**Checkpoint:** Commit this completed self-assessment as the **first review commit in your new repository**, before you modify or add application code. The lecturer decides the official original examination mark.

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1:**  

**Problem and correction 2:**  

**Problem and correction 3 (optional):**  

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 3 — missing booking or room:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 4 — requirement specific to my group:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?**  

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**  

**What will I do differently in my next coding test or API development task?**  

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
