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
      * **Note**: Considered integratable APIs are `CodeForces API` or an implementation
        of `Judge0 API`.
      * **Note**: This module is not final.
      <br/>
  * **Notification and Chatbot API**
      * All required automated tasks are notified and sent to the users.
      * **Note**: Done via either a `mailing server (SMTP)` or the `Facebook Graph API`.
      <br/> <br/>
      
----

  * **User Resource**
    * **GET** `/api/users` <br/>
      * **Description**: Returns array of users registered on the system.
      * **Note**: Also returns encrypted password field. Default response will be modified in a future commit.
      * **Note**: Response can be manipulated by giving a parameter of `projection`. Possible values for
                  projection are specified on the "profile"."href" field of the resource.
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
        "firstName" : "Rian SH",
        "middleName" : "fsdss",
        "lastName" : "LastNameTeeeeee",
        "emailAddress" : "queebskeleton@gmail.com",
        "facebookProfileUrl" : "https://facebook.com/queebskeleton",
        "birthdate" : "2001-02-01",
        "username" : "queebskeleton",
        "password" : "secretpassword"
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `200 OK` if success <br/><br/>
      ```json
      {
        "firstName": "Rian SH",
        "middleName": "fsdss",
        "lastName": "LastNameTeeeeee",
        "createdOn": "2020-04-17T23:40:57.862761",
        "emailAddress": "queebskeleton@gmail.com",
        "facebookProfileUrl": "https://facebook.com/queebskeleton",
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
      * **Sample Response Body**: `application/hal+json` or `application/json`, `200 OK` if success <br/><br/>
      ```json
      {
        "firstName": "Rian Asd",
        "middleName": "TestMiddleName",
        "lastName": "Reyessss",
        "createdOn": "2020-04-17T23:40:57.862761",
        "emailAddress": "queebskeleton@gmail.com",
        "facebookProfileUrl": "https://facebook.com/queebskeleton",
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
      * **Sample Response Body**: `204 No Content` if success. <br/><br/>
      
----

* **Event Resource**
    * **GET** `/api/events` <br/>
      * **Description**: Returns array of organization events on the system. Attendances on the event
                         are exposed on `/api/events/{id}/userEventAttendances` or `nonUserEventAttendances`.
                         Refer on the sample response below.
      * **Sample Response**: `application/hal+json` or `application/json` <br/><br/>
      ```json
      {
        "_embedded": {
          "events": [
            {
              "name": "Event 1",
              "venue": "PUP",
              "maxCountOfAttendees": 100,
              "briefDescription": "asd",
              "mainDescription": "asd",
              "createdOn": "2020-04-17T19:54:42.373022",
              "expectedStart": "2020-05-01T02:00:00",
              "expectedEnd": "2020-05-01T04:00:00",
              "status": "PENDING",
              "_links": {
                "self": {
                  "href": "http://localhost:8081/api/events/1"
                },
                "event": {
                  "href": "http://localhost:8081/api/events/1"
                },
                "nonUserEventAttendances": {
                  "href": "http://localhost:8081/api/events/1/nonUserEventAttendances"
                },
                "userEventAttendances": {
                  "href": "http://localhost:8081/api/events/1/userEventAttendances"
                },
                "usersPreRegistered": {
                  "href": "http://localhost:8081/api/events/1/usersPreRegistered{?projection}",
                  "templated": true
                }
              }
            }
          ]
        },
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/events{?page,size,sort}",
            "templated": true
          },
          "profile": {
            "href": "http://localhost:8081/api/profile/events"
          },
          "search": {
            "href": "http://localhost:8081/api/events/search"
          }
        },
        "page": {
          "size": 20,
          "totalElements": 1,
          "totalPages": 1,
          "number": 0
        }
      }
      ``` <br/><br/>
      
    * **GET** `/api/events/{id}/attendance-book.xlsx`
      * **Description**: Generates an excel workbook containing names of both users and non-users
                         who attended event with {id}.
      * **Note**: In a future commit, attendance generation will only be allowed when the *status* of the
                  event is set to `FINISHED`.
      * **Sample Response**: `application/vnd.ms-excel`, .xlsx file. (Sample image in a future commit)
    
    * **GET** `/api/events/{id}/usersPreRegistered` <br/>
      * **Description**: Returns array of users registered on this event.
      * **Sample Response**: `application/hal+json` or `application/json` <br/><br/>
      ```json
      {
        "_embedded": {
          "users": [
            {
              "firstName": "Rian Carlo",
              "middleName": "Zorilla",
              "lastName": "Reyes",
              "createdOn": null,
              "emailAddress": "queebskeleton@gmail.com",
              "facebookProfileUrl": null,
              "birthdate": "2001-01-31",
              "username": "queebskeleton",
              "password": "$2a$10$caJc4bWA1wwxbLibUPT9Je4.7MqSCwhDfdybcEpvWBGtnmXLrgYi2",
              "role": null,
              "_links": {
                "self": {
                  "href": "http://localhost:8081/api/users/1"
                },
                "user": {
                  "href": "http://localhost:8081/api/users/1{?projection}",
                  "templated": true
                }
              }
            }
          ]
        },
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/events/2/usersPreRegistered"
          }
        }
      }
      ``` <br/><br/>
      
    * **PUT** `/api/events/{id}/usersPreRegistered`
      * **Description**: Registers a user on this event. Give only URI of user.
      * **Sample Request Body**: `raw, application/json` <br/><br/>
      ```json
      {
        "_links": {
          "rel": "/1"
        }
      }
      ```
      * **Sample Response Body**: `204 No Content` If Success <br/><br/>

    * **POST** `/api/events` <br/>
      * **Description**: Creates an event resource
      * **Sample Request Body**: `raw, application/json`<br/><br/>
      ```json
      {
        "name": "Event 1",
        "venue": "PUP",
        "briefDescription": "asd",
        "mainDescription": "asd",
        "maxCountOfAttendees": 100,
        "expectedStart": "2020-05-01T02:00:00",
        "expectedEnd": "2020-05-01T04:00:00"
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `201 Created` if success <br/><br/>
      ```json
      {
        "name": "Event 1",
        "venue": "PUP",
        "maxCountOfAttendees": 100,
        "briefDescription": "asd",
        "mainDescription": "asd",
        "createdOn": "2020-04-18T00:06:45.765831",
        "expectedStart": "2020-05-01T02:00:00",
        "expectedEnd": "2020-05-01T04:00:00",
        "status": "PENDING",
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/events/2"
          },
          "event": {
            "href": "http://localhost:8081/api/events/2"
          },
          "nonUserEventAttendances": {
            "href": "http://localhost:8081/api/events/2/nonUserEventAttendances"
          },
          "userEventAttendances": {
            "href": "http://localhost:8081/api/events/2/userEventAttendances"
          },
          "usersPreRegistered": {
            "href": "http://localhost:8081/api/events/2/usersPreRegistered{?projection}",
            "templated": true
          }
        }
      }
      ``` <br/><br/>
    * **PUT** `/api/events/{id}` <br/>
      * **Description**: Updates ALL FIELDS of an event resource by `{id}` (all required fields are shown here)
      * **Sample Request Body**: `raw, application/json` <br/><br/>
      ```json
      {
        "name": "Event 1",
        "venue": "PUP-Sta.Mesa",
        "briefDescription": "asdasdasd",
        "mainDescription": "asasdasdasdasdd",
        "maxCountOfAttendees": 50,
        "expectedStart": "2020-05-01T02:00:00",
        "expectedEnd": "2020-05-01T04:00:00"
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `200 OK` if success <br/><br/>
      ```json
      {
        "name": "Event 1",
        "venue": "PUP-Sta.Mesa",
        "maxCountOfAttendees": 50,
        "briefDescription": "asdasdasd",
        "mainDescription": "asasdasdasdasdd",
        "createdOn": "2020-04-18T00:06:45.765831",
        "expectedStart": "2020-05-01T02:00:00",
        "expectedEnd": "2020-05-01T04:00:00",
        "status": null,
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/events/2"
          },
          "event": {
            "href": "http://localhost:8081/api/events/2"
          },
          "nonUserEventAttendances": {
            "href": "http://localhost:8081/api/events/2/nonUserEventAttendances"
          },
          "userEventAttendances": {
            "href": "http://localhost:8081/api/events/2/userEventAttendances"
          },
          "usersPreRegistered": {
            "href": "http://localhost:8081/api/events/2/usersPreRegistered{?projection}",
            "templated": true
          }
        }
      }
      ``` <br/><br/>

    * **PATCH** `/api/events/{id}` <br/>
      * **Description**: Updates GIVEN FIELDS of an event resource by `{id}`
      * **Sample Request Body**: `raw, application/json` <br/><br/>
      ```json
      {
        "name": "Proper Event Name ",
        "venue": "Polytechnic University of the Philippines - Sta. Mesa (Main Campus)"
      }
      ```
      * **Sample Response Body**: `application/hal+json` or `application/json`, `200 OK` if success <br/><br/>
      ```json
      {
        "name": "Proper Event Name ",
        "venue": "Polytechnic University of the Philippines - Sta. Mesa (Main Campus)",
        "maxCountOfAttendees": 50,
        "briefDescription": "asdasdasd",
        "mainDescription": "asasdasdasdasdd",
        "createdOn": "2020-04-18T00:06:45.765831",
        "expectedStart": "2020-05-01T02:00:00",
        "expectedEnd": "2020-05-01T04:00:00",
        "status": null,
        "_links": {
          "self": {
            "href": "http://localhost:8081/api/events/2"
          },
          "event": {
            "href": "http://localhost:8081/api/events/2"
          },
          "nonUserEventAttendances": {
            "href": "http://localhost:8081/api/events/2/nonUserEventAttendances"
          },
          "userEventAttendances": {
            "href": "http://localhost:8081/api/events/2/userEventAttendances"
          },
          "usersPreRegistered": {
            "href": "http://localhost:8081/api/events/2/usersPreRegistered{?projection}",
            "templated": true
          }
        }
      }
      ``` <br/><br/>
    
    * **DELETE** `/api/events/{id}` <br/>
      * **Description**: Deletes an event resource by {id}
      * **Sample Response Body**: `204 No Content` if success.
