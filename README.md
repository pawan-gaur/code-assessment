# code-assessment

* Step 1: Import **code-assessment** application as maven-project in any IDE
* Step 2: run **maven clean install** or Right click on `CodeAssessmentApplication.java`(main class) and click Run

### code-assessment app is Hosted on aws ec-2
* Deployed url : [http://ec2-65-0-109-214.ap-south-1.compute.amazonaws.com:8080](http://ec2-65-0-109-214.ap-south-1.compute.amazonaws.com:8080)
* Health Check url : [http://ec2-65-0-109-214.ap-south-1.compute.amazonaws.com:8080/health](http://ec2-65-0-109-214.ap-south-1.compute.amazonaws.com:8080/health)

GitHub Repository : https://github.com/pawan-gaur/code-assessment
Support CI/CD from the master branch. Changes deployment takes around 1m30sec

Please refer **curl_api** file for API's cURL path code-assessment\src\main\resources\curl_api

## REST API

Design and implement a RESTful API that generates unique tracking numbers for parcels. This
API should be scalable, efficient, and capable of handling high concurrency.


## [GET] /next-tracking-number
### Request

`GET /next-tracking-number`

    curl --location 'http://ec2-65-0-109-214.ap-south-1.compute.amazonaws.com:8080/next-tracking-number?origin_country_id=IN&destination_country_id=UK&weight=1.540&created_at=2025-01-18T10:18:04+05:30&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics'    
    curl --location 'localhost:8080/next-tracking-number?origin_country_id=IN&destination_country_id=UK&weight=1.540&created_at=2025-01-18T10:18:04+05:30&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics'

### Response

    {
        "trackingNumber": "DLINUKA810621B",
        "createdAt": "2025-01-19T17:06:29.4937932+05:30"
    }
