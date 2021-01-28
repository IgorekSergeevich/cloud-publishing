package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.employee.rest.services.PasswordGeneratorService
import org.passay.CharacterRule
import org.passay.EnglishCharacterData
import org.passay.PasswordGenerator
import org.springframework.stereotype.Component

@Component
class PasswordGeneratorServiceImpl(
    private val passwordGenerator: PasswordGenerator
) : PasswordGeneratorService {

    override fun generatePassword(): String {
        val upperCaseChars = EnglishCharacterData.UpperCase
        val upperCaseRule = CharacterRule(upperCaseChars)
        upperCaseRule.numberOfCharacters = 3

        val digitalChars = EnglishCharacterData.Digit
        val digitalRule = CharacterRule(digitalChars)
        digitalRule.numberOfCharacters = 3

        return passwordGenerator
            .generatePassword(16, upperCaseRule, digitalRule)
    }

}