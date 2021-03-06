# <center>CartAPI</center>
## <center>A Spring Boot REST API utilizing CRUD methods to imitate a Shopping Cart by providing a Client the option to insert, update, read and delete product data to a database via http.</center>


---

&nbsp;
## *All Supporting Documentation is found within the [Screenshots](/Screenshots/) folder*

&nbsp;

---

&nbsp;

### <center>App Running Locally</center>
![Application Running Locally](/Screenshots/Application%20Running.png "Application Running Locally")

---

### <center>Postman Create Method</center>

![Postman Create Method](/Screenshots/Postman/Product%20Create.png)

---

### <center>Postman Create Method 2</center>

![Postman Create Method](/Screenshots/Postman/Product%20Create%202.png)

---

### <center>Postman Read All Method</center>

![Postman Read All Method](/Screenshots/Postman/Product%20Read%20All.png)

---

### <center>Postman Read By Id Method</center>

![Postman Create Method](/Screenshots/Postman/Product%20Read%20By%20Id.png)

---

### <center>Postman Update Method</center>

![Postman Update Method](/Screenshots/Postman/Product%20Update.png)

---

### <center>Postman Delete Method</center>

![Postman Delete Method](/Screenshots/Postman/Product%20Delete.png)

---

# <center>Testing</center>

### All Tests

![All Tests](/Screenshots/Testing/All%20Tests.png)

---

### Integration Tests
![Integration Tests](/Screenshots/Testing/IntegrationTests_1.png)

---

### Entity Unit Tests

![Entity Unit Tests](/Screenshots/Testing/EntityUnitTests.png)

---

### Test Coverage

![Test Coverage](/Screenshots/Testing/UpdatedCoverage.png)

---

# <center>MySQL</center>

### Select All from Product

![Select All](/Screenshots/MySQL/Select%20All.png)

---

# <center>Agile</center>

## <center>[Scrum Board](https://davecheez.atlassian.net/jira/software/projects/CAR/boards/4)</center>

### Road Map

![Road Map](/Screenshots/Agile/Road%20Map.png)

---

### Sprint Back Log

![Back Log](/Screenshots/Agile/Sprint%20Backlog.png)

---

### Sprint

![Sprint](/Screenshots/Agile/CAR%20Sprint.png)

---

# <center>Network Graph</center>

![Network Graph](/Screenshots/Network%20Graph.png)
![Network Graph](/Screenshots/Network%20Graph%20Updated.png)

# <center>Risk Assessment</center>

![Risk Assessment](/Screenshots/Risk%20Assesment.png)

---

# <center>Enhancing the API</center>

## <center>*If the client requests to read an ID that does not exist in the database*</center>
### <center>We now return a 404 Response NOT FOUND</center>

&nbsp;

### Postman Read By ID Method when record does not exist (404 response)
![Postman Read By ID Method when record does not exist (404 response)](/Screenshots/Postman/ReadById%20does%20not%20exist.png)

---

&nbsp;
## <center>*If the client requests to update an ID that does not exist in the database*</center>
### <center>We now return a 404 Response NOT FOUND</center>

&nbsp;

### Postman Update By ID Method when record does not exist (404 response)
![Postman Update By ID Method when record does not exist (404 response)](/Screenshots/Postman/UpdateById%20does%20not%20exist.png)

---
&nbsp;

## <center>*If the client requests to delete an ID that does not exist in the database*</center>
### <center>We now return a 404 Response NOT FOUND</center>

&nbsp;

### Postman Delete By ID Method when record does not exist (404 response)
![Postman Delete By ID Method when record does not exist (404 response)](/Screenshots/Postman/DeleteById%20does%20not%20exist.jpg)