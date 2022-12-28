package me.enset.core.exception


abstract class VehicleOverSpeedingTicketException(message : String)
    : RuntimeException(message);
class VehicleOwnerAlreadyAffectedException(message : String) : VehicleOverSpeedingTicketException(message);
