package improbable.launcher

import improbable.apps.WorldApps
import improbable.bridgesettings.{DefaultBridgeSettingsResolver, UnityClientBridgeSettings, UnityFSimBridgeSettings}
import improbable.dapi.LaunchConfig
import improbable.unity.fabric.engine.DownloadableUnityConstraintToEngineDescriptorResolver

/**
  * These are the engine startup configs.
  *
  * ManualWorkerStartup will not start an engines when you start the game.
  * AutomaticWorkerStartup will automatically spool up engines as you need them.
  */
object ManualWorkerStartupConfig extends BaseLaunchConfig(useDynamicEngineSpooling = false)

object AutomaticWorkerStartupConfig extends BaseLaunchConfig(useDynamicEngineSpooling = true)

class BaseLaunchConfig(useDynamicEngineSpooling: Boolean) extends LaunchConfig(
  appsToStart = WorldApps.APPS_TO_START,
  useDynamicEngineSpooling = useDynamicEngineSpooling,
  bridgeSettingsResolver = DefaultBridgeSettingsResolver,
  constraintToEngineDescriptorResolver = DownloadableUnityConstraintToEngineDescriptorResolver
)


