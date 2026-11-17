# Community Health & Wellness System 🏥

**BBIT Year 3.2 Mobile Application Development - CAT 2 Project**
**Theme:** Health and Wellness for All

## Project Overview
Within many local neighborhoods, residents face significant barriers when trying to access basic health education, maternal/child wellness support, and routine medical consultations. Traditional healthcare centers often suffer from long physical queues, poor information distribution, and a lack of straightforward digital tools for citizens to schedule appointments.

The **Community Health & Wellness System** is an Android mobile application designed to act as a digital front desk for local health centers. It empowers patients to register, view a catalog of health services, book consultations instantly, and manage their scheduled appointments seamlessly from their mobile devices.

## Core Features
* **User Authentication:** Secure registration and login system with 4-digit PIN access.
* **Dynamic Service Directory:** Displays categorized available community health services.
* **Complete CRUD Functionality:**
  * **Create:** Book new health appointments.
  * **Read:** View active bookings dynamically via `RecyclerView` on the dashboard.
  * **Update:** Modify the date and time of existing appointments.
  * **Delete:** Cancel appointments and remove them from the system.
* **Background Processing:** Utilizes `WorkManager` to trigger reliable background appointment reminders, ensuring patients don't miss their consultations.
* **Form Validation:** Comprehensive error handling for empty fields and invalid inputs during registration and booking.

## Technical Stack & Architecture
This application implements modern Android development standards and a robust **Single-Activity MVVM Architecture**:

* **Language:** Kotlin
* **UI & Layout:** XML with `ViewBinding` and Material Design Components.
* **Navigation:** Android Navigation Component (`nav_graph.xml`) for seamless Fragment transitions.
* **Data Persistence:** **SQLite (`SQLiteOpenHelper`)** ensuring local data remains available even after the application is closed.
* **Asynchronous Programming:** Kotlin Coroutines & `Dispatchers.IO` for non-blocking database queries.

### Architecture Data Flow
`UI (Fragment)` ➔ `ViewModel (HealthViewModel)` ➔ `Repository (HealthRepository)` ➔ `Data Source (DatabaseHelper)`

1. **UI Layer:** Captures user input (e.g., `BookAppointmentFragment`).
2. **ViewModel:** Holds UI state and executes business logic via Coroutines.
3. **Repository:** Acts as the single source of truth, abstracting the data source.
4. **Data Source:** `DatabaseHelper` executes raw SQL queries to persist data in SQLite.

## Installation & Setup Instructions
To run this project locally for testing or evaluation:
1. Clone this repository to your local machine.
2. Open the project in **Android Studio** (Koala / Ladybug or newer recommended).
3. Allow Gradle to sync the dependencies (Kotlin, WorkManager, Navigation Component).
4. Set up an Android Virtual Device (AVD). A **Pixel 10a (API 34-37)** emulator is recommended.
5. Click **Run (Shift + F10)** to install and launch the application.

## 👥 Group 8 Members & Contributions
This project was collaboratively developed using GitHub branches and pull requests.
* **167409 Katama David Michael** - *(e.g., UI/UX Design, Navigation Graph, Booking Logic)*
* **191339 Ahumuza Lowena** - *(e.g., SQLite Database Implementation, Repository Architecture)*
* **167044 Kyarua Wesley Ralph** - *(e.g., Authentication Logic, WorkManager Background Processing)*
* **193183 Tugumisirize Patricia** - *(e.g., Dashboard RecyclerView, Dynamic Adapters, CRUD Testing)*

---
This README serves as excellent documentation for your repository. It explains the problem, the solution, the exact tech stack you used, and outlines the architecture perfectly for the lecturer to review. 

Make sure to push this to your GitHub repository's main folder. Best of luck with your CAT 2 presentation and technical defense—you have built a highly functional and robust application!
