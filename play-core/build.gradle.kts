val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false

repositories {
    mavenCentral()
}

val redissonVersion = "3.28.0"

dependencies {
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.redisson:redisson-spring-boot-starter:${redissonVersion}")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("software.amazon.awssdk:secretsmanager:2.27.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}