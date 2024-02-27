package dto;

import java.util.List;

public record ResponseUsersDTO(
        int id,
        String firstName,
        String lastName,
        String maidenName,
        int age,
        String gender,
        String email,
        String phone,
        String username,
        String password,
        String birthDate,
        String image,
        String bloodGroup,
        int height,
        double weight,
        String eyeColor,
        Hair hair,
        String domain,
        String ip,
        Address address,
        String macAddress,
        String university,
        Bank bank,
        Company company,
        String ein,
        String ssn,
        String userAgent,
        List<Users> users
) {
    public record Hair(String color, String type) {}
    public record Address(String address, String city, Coordinates coordinates, String postalCode, String state) {}
    public record Coordinates(double lat, double lng) {}
    public record Bank(String cardExpire, String cardNumber, String cardType, String currency, String iban) {}
    public record Company(Address address, String department, String name, String title) {}
    public record Users (
            int id,
            String firstName,
            String lastName,
            String maidenName,
            int age,
            String gender,
            String email,
            String phone,
            String username,
            String password,
            String birthDate,
            String image,
            String bloodGroup,
            int height,
            double weight,
            String eyeColor,
            Hair hair,
            String domain,
            String ip,
            Address address,
            String macAddress,
            String university,
            Bank bank,
            Company company,
            String ein,
            String ssn,
            String userAgent
    ) {
    }
}