package uk.gov.hmcts.reform.draftstore.service.crypto

import org.amshove.kluent.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class CryptoServiceSpec : Spek({

  describe("CryptoService") {

    given("a message and a secret") {

      val originalMessage = "hello world!"
      val secret = "this is my sample secret"

      describe("encrypting") {
        val encryptedMessage = CryptoService.encrypt(originalMessage, secret)

        it("should encrypt message") {
          encryptedMessage `should not equal` originalMessage.toByteArray()
        }

        describe("decrypting with the same secret") {
          val decrypted = CryptoService.decrypt(encryptedMessage, secret)

          it("should return the original message") {
            decrypted `should equal` originalMessage

            decrypted shouldEqual originalMessage
          }
        }

        describe("decrypting with a different secret") {
          val decrypting = { CryptoService.decrypt(encryptedMessage, "totally different secret") }

          it("should throw an exception") {
            decrypting `should throw` InvalidKeyException::class
          }
        }
      }
    }
  }
})
