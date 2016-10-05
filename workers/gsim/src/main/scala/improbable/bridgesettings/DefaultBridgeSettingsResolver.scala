package improbable.bridgesettings

import improbable.fapi.bridge.CompositeBridgeSettingsResolver

/**
  * Created by chong-u on 05/10/2016.
  */
object DefaultBridgeSettingsResolver extends CompositeBridgeSettingsResolver(
  UnityClientBridgeSettings,
  UnityFSimBridgeSettings
)
