# Write your MySQL query statement below
SELECT Person.FirstName, Person.LastName, Address.City, Address.state FROM 
Person LEFT JOIN Address
ON Person.PersonId = Address.PersonId;
