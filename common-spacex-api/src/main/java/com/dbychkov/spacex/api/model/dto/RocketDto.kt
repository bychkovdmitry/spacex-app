package com.dbychkov.spacex.api.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RocketDto(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String,
    @Json(name = "active") val active: Boolean,
    @Json(name = "stages") val stages: Int,
    @Json(name = "boosters") val boosters: Int,
    @Json(name = "cost_per_launch") val costPerLaunch: Long,
    @Json(name = "success_rate_pct") val successRatePercentage: Double,
    @Json(name = "first_flight") val firstFlight: String,
    @Json(name = "country") val country: String,
    @Json(name = "company") val company: String,
    @Json(name = "height") val height: LengthDto,
    @Json(name = "diameter") val diameter: LengthDto,
    @Json(name = "mass") val mass: MassDto,
    @Json(name = "payload_weights") val payloadWeights: List<PayloadWeightDto>,
    @Json(name = "first_stage") val firstStage: FirstStageDto,
    @Json(name = "second_stage") val secondStage: SecondStageDto,
    @Json(name = "engines") val engines: EnginesDto,
    @Json(name = "landing_legs") val landingLegs: LandingLegsDto,
    @Json(name = "flickr_images") val flickrImages: List<String>,
    @Json(name = "wikipedia") val wikipedia: String,
    @Json(name = "description") val description: String
)

@JsonClass(generateAdapter = true)
data class LengthDto(
    @Json(name = "meters") val metres: Double,
    @Json(name = "feet") val feet: Double
)

@JsonClass(generateAdapter = true)
data class MassDto(
    @Json(name = "kg") val kg: Double,
    @Json(name = "lb") val lb: Double
)

@JsonClass(generateAdapter = true)
data class PayloadWeightDto(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "kg") val kg: Double,
    @Json(name = "lb") val lb: Double
)

@JsonClass(generateAdapter = true)
data class FirstStageDto(
    @Json(name = "reusable") val reusable: Boolean?,
    @Json(name = "engines") val engines: Int?,
    @Json(name = "fuel_amount_tons") val fuelAmountTons: Double?,
    @Json(name = "burn_time_sec") val burnTimeSec: Double?,
    @Json(name = "thrust_sea_level") val thrustSeaLevel: ThrustDto?,
    @Json(name = "thrust_vacuum") val thrustVacuum: ThrustDto?
)

@JsonClass(generateAdapter = true)
data class ThrustDto(
    @Json(name = "kN") val kN: Double?,
    @Json(name = "lbf") val lbf: Double?
)

@JsonClass(generateAdapter = true)
data class SecondStageDto(
    @Json(name = "reusable") val reusable: Boolean,
    @Json(name = "engines") val engines: Int,
    @Json(name = "fuel_amount_tons") val fuelAmountTons: Double,
    @Json(name = "burn_time_sec") val burnTimeSec: Double,
    @Json(name = "thrust") val thrust: ThrustDto,
    @Json(name = "payloads") val payloads: Payloads
) {

    @JsonClass(generateAdapter = true)
    data class Payloads(
        @Json(name = "option_1") val optionOne: String?,
        @Json(name = "composite_fairing") val compositeFairing: CompositeFairingDto
    ) {

        @JsonClass(generateAdapter = true)
        data class CompositeFairingDto(
            @Json(name = "height") val height: LengthDto,
            @Json(name = "diameter") val diameter: LengthDto
        )
    }
}

@JsonClass(generateAdapter = true)
data class EnginesDto(
    @Json(name = "number") val number: Int,
    @Json(name = "type") val type: String,
    @Json(name = "version") val version: String,
    @Json(name = "layout") val layout: String,
    @Json(name = "engine_loss_max") val engineLossMax: Int,
    @Json(name = "propellant_1") val propellantOne: String,
    @Json(name = "propellant_2") val propellantTwo: String,
    @Json(name = "thrust_sea_level") val thrustSeaLevel: ThrustDto,
    @Json(name = "thrust_vacuum") val thrustVacuum: ThrustDto,
    @Json(name = "thrust_to_weight") val thrustToWeight: Double
)


@JsonClass(generateAdapter = true)
data class LandingLegsDto(
    @Json(name = "number") val number: Int,
    @Json(name = "material") val material: String
)
