# Task Manager Application
The Task Manager Application is a RESTful web service for managing tasks.

#### Get All Tasks
- Method: GET
- URL: ``/api/v1/tasks``
- Description: Retrieves all tasks.

**Response:**
- Status Code: 200 OK
- Body: Returns an array of task objects.

#### Get Task by ID
- Method: GET
- URL: ``/api/v1/tasks/{id}``
- Description: Retrieves a task by its ID.

**Parameters:**
- {id}: The ID of the task to retrieve.

**Response:**
- Status Code: 200 OK
- Body: Returns the task object with the specified ID.

#### Update Task by ID
- Method: PUT
- URL: ``/api/v1/tasks/{id}``
- Description: Updates a task by its ID.

**Parameters:**
- {id}: The ID of the task to update.

**Response:**
- Status Code: 200 OK
- Body: Returns the updated task object.

#### Delete Task by ID
- Method: DELETE
- URL: ``/api/v1/tasks/{id}``
- Description: Deletes a task by its ID.

**Parameters:**
- {id}: The ID of the task to delete.

**Response:**
- Status Code: 200 OK