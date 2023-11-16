# Project descriptions

This is the first version of the "Awesome pizza" where customers can only place an order for a specific day, without the
possibility to choose the hour. The orders are delivered in a FIFO (first in first out) criteria. 
There are 2 turn for each day, one for the lunch and one for the dinner. In each turn can be placed a limited 
number of pizza (parametric number in configuration). 

# Requirements - use case

### Add new order

User can insert a new order choosing a pizza in the catalog.
There can be at most N number of orders in a day for a slot.

### Order in queue

A scheduled task set the order in the status "in queue"

### Order in progress

Employee set the order in the status "in progress"

### Order ready for pickup

Employee set the order in the status "order ready for pickup"

### Order completed

Employee set the order in the status "order completed"

### Get order status

Get the status of the order.
Now the order request is cached for 1 second so if you try to do lot of request doesn't ask to db.
In next version there could be a better design system like having websocket/ use firebase/some cloud event system.

### Pizza information

User get the pizza informations like: name, ingredients and costs.

# ToDo improvements

- Allow to specify a specific hour for orders
- Add documentation (swagger)
