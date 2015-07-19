# Running the application

1. Launch SBT:

        $ sbt

2. Compile everything and run all tests:

        > test

3. Start the application:

        > re-start

4. Browse to [http://localhost:8080](http://localhost:8080/)

5. Stop the application:

        > re-stop

6. Learn more at http://www.spray.io/

## Running inside Docker

        sbt assembly
        docker build -t irbis/invoices .
        docker run --rm -p 9090:8080 irbis/invoices:latest
        
Or run as a daemon
        
        $INVOICE=(docker run -d -p 9090:8080 irbis/invoices:latest)
        