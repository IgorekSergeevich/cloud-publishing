package com.ikuzmin.cloud.publishing.model.roles


enum class EmployeeType(val type: String) {
    JOURNALIST("Journalist"), REDACTOR("Redactor");

    companion object {

        fun getByType(type: String): EmployeeType? {
            for (t in EmployeeType.values()) {
                if (t.type == type) {
                    return t
                }
            }
            return null;
        }

    }
}