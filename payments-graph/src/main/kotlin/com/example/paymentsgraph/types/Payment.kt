package com.example.paymentsgraph.types

import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import java.time.OffsetDateTime

@KeyDirective(FieldSet("id"))
data class Payment(
  @GraphQLID val id: String,
  val createdAt: OffsetDateTime,
  val updatedAt: OffsetDateTime,
  val amountMoney: Money,
  val tipMoney: Money,
  val totalMoney: Money,
  val appFeeMoney: Money,
  val processingFee: List<ProcessingFee>,
  val refundedMoney: Money? = null,
  val status: String, // APPROVED, COMPLETED, CANCELED, or FAILED
  val sourceType: String, // CARD
  val cardDetails: CardPaymentDetails,
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
