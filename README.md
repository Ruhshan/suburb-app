## How To Test Locally

### Clone the repository
```bash
git clone https://github.com/Ruhshan/suburb-app.git
```

### Run the docker container
```bash
docker compose up
```

### Create suburbs
```bash
curl --location --request POST 'http://localhost:5000/api/suburbs' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "name":"Melborne",
        "postcode":100
    },
    {
        "name":"Sydney",
        "postcode":"200"
    },
    {
        "name":"Brisbane",
        "postcode": 300
    },
    {
        "name":"Perth",
        "postcode":400
    },
    {
        "name":"Adelaid",
        "postcode":500
    },
    {
        "name":"Canberra",
        "postcode":600
    },
    {
        "name":"Hobar",
        "postcode":700
    },
    {
        "name":"Darwin",
        "postcode":800
    }
]'
```

### Get suburbs by post code range
```bash
curl --location --request GET 'http://localhost:5000/api/suburbs?start=100&end=800' \
--header 'Content-Type: application/json'

```

### Api Doc location
http://localhost:5000/v3/swagger-ui/


## How To Test From Deployed Heroku

Replace **http://localhost:5000/api/suburbs** with **https://suburb-app.herokuapp.com/api/suburbs**

## Api Doc Location
https://suburb-app.herokuapp.com/v3/swagger-ui/
