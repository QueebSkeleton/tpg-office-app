**TPG - Office Management Application - APIs**
----

  An Office Management Application dedicated to the Polytechnic University of the Philippines,
  The Programmers' Guild organization. It is used to manage necessary information for
  the organization to easily do its everyday tasks.
  
  Implementation is limited as of the moment.
  
  Implemented as a series of REST APIs, set to be integrated with a UI Application.
  
  ----
  
  **Target Functionalities**
  
  * **User Management** <br/>
      * Manages all users (officers, members) and their relevant data in the application.
      <br/>
  * **Event Organizer** <br/>
      * Organizes and manages events the organization will have. An event may be an
        organization-held event, or simply a meeting.
      * Manages attendance for every event.
      * Able to generate required documents (attendance sheets, event information).
      * All required attendees are notified of the event (on its creation date, 1
        day before it commences, and at its commencement date) through a 
        `mailing server (SMTP)` or the `Facebook Graph API`.
      <br/>
  * **Logging Capabilities** <br/>
      <br/>
  * **Paperwork Generator** <br/>
      * Ease paperwork fillups thru the application paperwork generator. The app will
        generate and respond a PDF file of the required paperwork.
      * **Note**: Digital Signing will not be implemented.
      <br/>
  * **TPG Project Manager and Organizer** <br/>
      * Creates and manages projects and solutions developed by the officers and members of the
        organization. It may include all types of projects, software or hardware based.
      <br/>
  * **Daily Coding Challenges** <br/>
      * Provides an easy to use interface for coding challenges.
      * An appointed officer will set up a coding challenge thru the app, and notifies
        all the other members that is required to solve it, through either mail or the
        Facebook Graph API.
      * All source codes can be submitted directly in the application, and will notify
        of results.
      * **Note**: Considered integratable APIs are `CodeForces API` or the Code `Judger API`.
      * **Note**: This module is not final.
      <br/>
  * **Notification and Chatbot API**
      * All required automated tasks are notified and sent to the users.
      * **Note**: Done via either a `mailing server (SMTP)` or the `Facebook Graph API`.
      <br/>
      
----

**APIs Implemented**

As of the moment, there are 2 APIs implemented and exposed on the application:
  * User Management APIs
  * Event Creation API
  
**API Specs**

API specs are to be defined here in a (soonest) future commit.
      
