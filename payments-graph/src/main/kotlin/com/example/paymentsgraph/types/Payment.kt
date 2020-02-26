package com.example.paymentsgraph.types

import com.example.graphcommon.types.Address
import com.example.graphcommon.types.Money
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import java.time.OffsetDateTime

@KeyDirective(FieldSet("id"))
data class Payment(
  @GraphQLID val id: String,
  val createdAt: OffsetDateTime = OffsetDateTime.now(),
  val updatedAt: OffsetDateTime = OffsetDateTime.now(),
  val amountMoney: Money,
  val tipMoney: Money = Money(0, "USD"),
  val totalMoney: Money = Money(0, "USD"),
  val appFeeMoney: Money = Money(0, "USD"),
  val processingFee: List<ProcessingFee> = listOf(),
  val refundedMoney: Money? = null,
  val status: String = "APPROVED", // APPROVED, COMPLETED, CANCELED, or FAILED
  val sourceType: String = "CARD", // CARD
  val cardDetails: CardPaymentDetails? = null,
  val referenceId: String? = null,
  val buyerEmailAddress: String? = null,
  val billingAddress: Address? = null,
  val shippingAddress: Address? = null,
  val note: String? = null,
  val statementDescriptionIdentifier: String? = null,
  val receipt: Receipt? = null,

  private val customerId: String,
  private val employeeId: String,
  private val locationId: String
) {
  fun customer() = Customer(customerId)
  fun employee() = Employee(employeeId)
  fun location() = Location(locationId)
}

data class PaymentPaginated(
  val nodes: List<Payment>,
  val cursor: String? = null
)
