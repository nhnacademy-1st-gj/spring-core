Water Rate Calculator Program
=====

Requirement 1
----
Load the provided water rate chart into memory and provide a function that displays the rate by local government and business type based on the usage entered by the user. Display only the five items with the lowest price (billTotal) in ascending order.

Requirement 2
----
Save the execution time of all methods of the running Spring Bean to the elapse.log file. (You must use AOP.) Design Requirements

Design Requirements
----
#### You must create the following Spring Beans, each with its own role:
- Spring Bean that parses the CSV file (including interface)
- Spring Bean that displays results on the screen (including interface)
- Spring Bean that stores and retrieves water rate data
- Spring Bean that finds the section in the water rate chart based on the usage entered and calculates the rate

Logical Design
----
![image](https://user-images.githubusercontent.com/103839217/229132737-774fa575-5759-40b7-8877-4cc759752f32.png)
