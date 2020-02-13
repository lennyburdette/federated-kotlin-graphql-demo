package com.example.identitiesgraph.types

import java.time.OffsetDateTime

data class BusinessHours(
  val periods: List<BusinessHoursPeriod>
)

data class BusinessHoursPeriod(
  val dayOfWeek: String,
  val endLocalTime: OffsetDateTime,
  val startLocalTime: OffsetDateTime
)
