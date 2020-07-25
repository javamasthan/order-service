# order-service
order management system 



here please find order-item Rest API url for create -> POST method http://localhost:8081/item/create

 request ->

{
	"productName":"Laptop",
	"productCode":"Lap-01",
	"quantity":1
}

response ->

{
    "id": 1,
    "productName": "Laptop",
    "productCode": "Lap-01",
    "quantity": 1
}

order-item retriving exsting orders Rest API  url for fetch -> GET method http://localhost:8081/item//allItemOrders

response ->

[
    {
        "id": 1,
        "productName": "Laptop",
        "productCode": "Lap-01",
        "quantity": 1
    },
    {
        "id": 2,
        "productName": "Mobile",
        "productCode": "Mob-01",
        "quantity": 10
    }
]

order-info regarding customer Rest API url for create -> POST method http://localhost:8082/order/create

sample request 

{
	 "customerName":"Raj",
	 "shippingAddress":"Hyderabad",
	 "total":12,
	 "orderItem":1,
	"orderDate":"07/25/2020"
}

order-item retriving exsting orders customer info Rest API  url for fetch -> GET method http://localhost:8082/order//allCustomerInfo

response ->
[
    {
        "id": 1,
        "customerName": "Raj",
        "shippingAddress": "Hyderabad",
        "total": 12,
        "orderItem": 1,
        "orderDate": "25 Jul, 2020 12:00:00 AM"
    },
    {
        "id": 2,
        "customerName": "Masthan",
        "shippingAddress": "Hyderabad",
        "total": 12,
        "orderItem": 1,
        "orderDate": "25 Jul, 2020 12:00:00 AM"
    }
]


feign-client creating order-item and feting all order items 

http://localhost:8083/feign/order/create

http://localhost:8083/feign/order/allOrders



feign-client creating order-info and fetching all order info 

http://localhost:8083/feign/orderInfo/create

http://localhost:8083/feign/orderInfo/allOrdersInfo









