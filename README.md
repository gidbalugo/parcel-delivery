# parcel-delivery
Parcel Delivery project

# Overview

The project does not use any kind of database as it only needs to calculate delivery cost based on parcel's specifications.
This same project will host both the API to calculate the delivery cost, and the API to fetch voucher due to issue encountered.

# API Endpoints

### Endpont: `api/delivery/calculate`
* This is the endpoint to calculate delivery cost based on parcel dimensions
* Sample request below:
```json
{
   "weight": 51,
   "height": 1,
   "width": 1,
   "length": 1,
   "voucher": "MYNT"
}
```

* Sample Output:
```json
{
    "deliveryCost": 900.0,
    "voucherApplied": true
}
```

### API Endpoint: `/voucher`
* This is a mock endpoint as a workaround to simulate successful application of voucher due to issue encountered using the provided mock voucher endpoint: https://mynt-exam.mocklab.io/voucher/.

# Dependencies

* 'org.springframework.boot:spring-boot-starter-validation'
  * Used for validation
* 'org.springframework.boot:spring-boot-starter-web'
  * Used for REST API

# Issues encountered

I wasn't able to fully replicate the fetching of voucher from the test endpoint provided in the below link:
* https://app.swaggerhub.com/apis/mynt-iat/mynt-programming-exams/1.1.0#/voucher/voucher

I keep on getting 504 which led to creating my own voucher endpoint to simulate successful application of vouchers.
Please note that the voucher endpoint produces a hardcoded discounted. See `VoucherController.java` for reference

# Rates and limits

I decided to externalize values of rates and limits to `.properties` file for us to easily change it when needed.
