rootProject.name = "example-graph"

include(":identities-graph")
include(":payments-graph")

project(":identities-graph").projectDir = file("identities-graph")
project(":payments-graph").projectDir = file("payments-graph")
