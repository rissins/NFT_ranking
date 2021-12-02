plugins {
    id("com.diffplug.spotless")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

spotless {
    format("misc") {
        target("*.gradle", "*.gradle.kts", "*.gitignore")
        indentWithTabs()
        trimTrailingWhitespace()
        endWithNewline()
    }

    format("documentation") {
        target("*.adoc", "*.md", "src/**/*.adoc", "src/**/*.md")
        trimTrailingWhitespace()
        endWithNewline()
    }

    java {
        target("src/*/java/**/*.java")

        eclipse("4.21.0")

        indentWithTabs()
        trimTrailingWhitespace()
        endWithNewline()
    }
}
