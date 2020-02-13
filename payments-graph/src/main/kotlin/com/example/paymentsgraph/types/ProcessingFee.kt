package com.example.paymentsgraph.types

import java.time.OffsetDateTime

data class ProcessingFee(
  val amountMoney: Money,
  val effectiveAt: OffsetDateTime,
  val type: String // INITIAL, ADJUSTMENT
)
