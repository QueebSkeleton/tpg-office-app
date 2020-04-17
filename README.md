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

**APIs Implemented*

  * **Users Resource**
    * **GET** `/api/users` <br/>
      * **Description**: Returns array of users registered on the system.
      * **Note**: Also returns encrypted password field. To be modified in a future commit.
      * **Sample Response**: `application/hal+json` or `application/json` <br/><br/>
      ```json
      {
        "_embedded" : {
          "users" : [ {
            "firstName" : "Rian Carlo",
            "middleName" : "Zorilla",
            "lastName" : "Reyes",
            "createdOn" : "2020-04-17T19:54:19.432605",
            "emailAddress" : "queebskeleton@gmail.com",
            "facebookProfileUrl" : null,
            "birthdate" : "2001-02-01",
            "username" : "queebskeleton",
            "password" : "$2a$10$Ust3mIVP3KXt5GYoVIziDuVH2ebBl5z7msEYr68kCLUWGNtcWc.l.",
            "role" : "ADMINISTRATOR",
            "_links" : {
              "self" : {
                "href" : "http://localhost:8081/api/users/1"
              },
              "user" : {
                "href" : "http://localhost:8081/api/users/1{?projection}",
                "templated" : true
              }
            }
          } ]
        },
        "_links" : {
          "self" : {
            "href" : "http://localhost:8081/api/users{?page,size,sort,projection}",
            "templated" : true
          },
          "profile" : {
            "href" : "http://localhost:8081/api/profile/users"
          },
          "search" : {
            "href" : "http://localhost:8081/api/users/search"
          }
        },
        "page" : {
          "size" : 20,
          "totalElements" : 1,
          "totalPages" : 1,
          "number" : 0
        }
      }
      ``` <br/><br/>

    * **POST** `/api/users` <br/>
      * **Description**: Creates a user resource
      * **Sample Request Body**: `raw, application/json`<br/><br/>
      ```json
      {
        "firstName" : "Rian Carlo",
        "middleName" : "Zorilla",
        "lastName" : "Reyes",
        "emailAddress" : "queebskeleton@gmail.com",
        "facebookProfileUrl" : null,
        "birthdate" : "2001-02-01",
        "username" : "queebskeleton",
        "password" : "secretpassword"
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `201 Created` if success <br/><br/>
      ```json
      {
        "firstName": "Rian Carlo",
        "middleName": "Zorilla",
        "lastName": "Reyes",
        "createdOn": "2020-04-17T23:40:57.862761",
        "emailAddress": "queebskeleton@gmail.com",
        "facebookProfileUrl": null,
        "birthdate": "2001-02-02",
        "username": "queebskeleton",
        "password": "$2a$10$9Ibq/SY5GkOvUIUf1KSwjeulHin/mNTO9.Cuc3CjHjSyj6znHSgbK",
        "role": "ADMINISTRATOR",
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/users/2"
          },
          "user": {
            "href": "http://localhost:8081/api/users/2{?projection}",
            "templated": true
          }
        }
      }
      ``` <br/><br/>
    * **PUT** `/api/users/{id}` <br/>
      * **Description**: Updates ALL FIELDS of a user resource by `{id}` (all required fields are shown here)
      * **Sample Request Body**: `raw, application/json` <br/><br/>
      ```json
      {
        "firstName" : "Rian Carlo",
        "middleName" : "Zorilla",
        "lastName" : "Reyes",
        "emailAddress" : "queebskeleton@gmail.com",
        "facebookProfileUrl" : null,
        "birthdate" : "2001-02-01",
        "username" : "queebskeleton",
        "password" : "secretpassword"
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `200 OK` if success
      ```json
      {
        "firstName": "Rian Carlo",
        "middleName": "Zorilla",
        "lastName": "Reyes",
        "createdOn": null,
        "emailAddress": "queebskeleton@gmail.com",
        "facebookProfileUrl": null,
        "birthdate": "2001-02-02",
        "username": "queebskeleton",
        "password": "$2a$10$.5sR7TaqK4HNQPhFCab2ue88TD5e5ke8qEjNeqOJ0OCZVvFC3KUOO",
        "role": "ADMINISTRATOR",
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/users/2"
          },
          "user": {
            "href": "http://localhost:8081/api/users/2{?projection}",
            "templated": true
          }
        }
      }
      ``` <br/><br/>

    * **PATCH** `/api/users/{id}` <br/>
      * **Description**: Updates GIVEN FIELDS of a user resource by `{id}`
      * **Sample Request Body**: `raw, application/json` <br/><br/>
      ```json
      {
        "firstName" : "Rian Asd",
        "middleName" : "TestMiddleName",
        "lastName" : "Reyessss",
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `200 OK` if success
      ```json
      {
        "firstName": "Rian Asd",
        "middleName": "TestMiddleName",
        "lastName": "Reyessss",
        "createdOn": null,
        "emailAddress": "queebskeleton@gmail.com",
        "facebookProfileUrl": null,
        "birthdate": "2001-02-02",
        "username": "queebskeleton",
        "password": "$2a$10$.5sR7TaqK4HNQPhFCab2ue88TD5e5ke8qEjNeqOJ0OCZVvFC3KUOO",
        "role": "ADMINISTRATOR",
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/users/2"
          },
          "user": {
            "href": "http://localhost:8081/api/users/2{?projection}",
            "templated": true
          }
        }
      }
      ``` <br/><br/>
    
    * **DELETE** `/api/users/{id}` <br/>
      * **Description**: Deletes a user resource by {id}
      * **Sample Response Body**: `204 No Content` if success.
