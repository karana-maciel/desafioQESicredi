plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation ("com.github.javafaker:javafaker:1.0.2")
}

tasks.test {
    useJUnitPlatform()
}