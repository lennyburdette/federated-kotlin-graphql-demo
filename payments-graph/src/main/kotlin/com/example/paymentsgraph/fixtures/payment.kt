package com.example.paymentsgraph.fixtures

import com.example.graphcommon.types.Money
import com.example.paymentsgraph.types.Payment

internal val payments = mapOf(
    "p1" to Payment(id = "p1", amountMoney = Money(1, "USD"), locationId = "l1", customerId = "c1", employeeId = "e1"),
    "p2" to Payment(id = "p2", amountMoney = Money(2, "USD"), locationId = "l1", customerId = "c2", employeeId = "e1"),
    "p3" to Payment(id = "p3", amountMoney = Money(3, "USD"), locationId = "l1", customerId = "c3", employeeId = "e1"),
    "p4" to Payment(id = "p4", amountMoney = Money(4, "USD"), locationId = "l1", customerId = "c1", employeeId = "e1"),
    "p5" to Payment(id = "p5", amountMoney = Money(5, "USD"), locationId = "l1", customerId = "c2", employeeId = "e1"),
    "p6" to Payment(id = "p6", amountMoney = Money(6, "USD"), locationId = "l2", customerId = "c3", employeeId = "e1"),
    "p7" to Payment(id = "p7", amountMoney = Money(7, "USD"), locationId = "l2", customerId = "c1", employeeId = "e1"),
    "p8" to Payment(id = "p8", amountMoney = Money(8, "USD"), locationId = "l2", customerId = "c2", employeeId = "e1"),
    "p9" to Payment(id = "p9", amountMoney = Money(9, "USD"), locationId = "l2", customerId = "c3", employeeId = "e1"),
    "p10" to Payment(id = "p10", amountMoney = Money(10, "USD"), locationId = "l2", customerId = "c1", employeeId = "e1")
)

internal val merchantPaymentIndex = mapOf(
  "m1" to payments
)

fun getPayment(id: String): Payment? = payments[id]

fun getPaymentsForLocation(id: String): List<Payment> {
  return payments.filterValues { it.location().id == id }.values.toList()
}

fun getPaymentsForMerchant(id: String): List<Payment> {
  return merchantPaymentIndex[id]?.values?.toList() ?: listOf()
}