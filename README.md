# MoneyTransferAPI
A sample spring boot project for book store


### Prerequisite
- Maven
- JDK 1.8+

### Packaging
```
mvn package
```
### Test
```
mvn test
```
### Running
```
java -jar BookStoreAPI-0.0.1-SNAPSHOT-spring-boot.jar
```
### Data
Initial data (src\main\resources\bookstore-mock.json) will be loaded in the H2 database when application start.

## Feature
It provides APIs for following 2 features
- create book
- update book
- delete book
- fetch all books
- checkout with promotion/discounts
- checkout without promotion/discounts

### Basic API Information
| Method | Path | Usage |
| --- | --- | --- |
| POST | /api/book/ | create book |
| GET | /api/book/ | fetch all books information |
| GET | /api/book/{id} | fetch book information |
| PUT | /api/book/{id} | update book information |
| DELETE | /api/book/{id} | delete book information |
| POST | /api/operation/ | checkout without promotion/discounts |
| POST | /api/operation/{code} | checkout with promotion/discounts |

### Error Code
| Code | Description |
| --- | --- |
| ERR_ACC_B_0002 | used when book does not exist. |
| ERR_ACC_B_0005 | used when book already exist. |


### Library used
| Library | Usage |
| --- | --- |
| spring boot | for spring boot application |
| spring data jpa | for ORM and DB operation purpose |
| H2 | database for demo purpose |
| springfox swagger | generate swagger API specification from code |
| springfox swagger ui | generate swagger ui page for specification |
