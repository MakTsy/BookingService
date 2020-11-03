FROM openjdk:14
ADD target/BookingService.jar BookingService.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "BookingService.jar"]