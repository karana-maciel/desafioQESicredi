package dto;

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
        String userAgent
) {
    public static record Hair(String color, String type) {}
    public static record Address(String address, String city, Coordinates coordinates, String postalCode, String state) {}
    public static record Coordinates(double lat, double lng) {}
    public static record Bank(String cardExpire, String cardNumber, String cardType, String currency, String iban) {}
    public static record Company(Address address, String department, String name, String title) {}
}