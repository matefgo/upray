package com.upray.project.web.model;

public record ProjectEntry(String name, String originalVersion, String upgradeVersion, int status, int phase) {
}
