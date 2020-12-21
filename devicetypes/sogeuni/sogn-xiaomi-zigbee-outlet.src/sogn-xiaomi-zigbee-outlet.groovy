/**
 *	Copyright 2015 SmartThings
 *
 *	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *	in compliance with the License. You may obtain a copy of the License at:
 *
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *	on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *	for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
	definition (name: "Sogn Xiaomi Zigbee Outlet", namespace: "sogeuni", author: "sogeuni", ocfDeviceType: "oic.d.switch", runLocally: true, minHubCoreVersion: '000.019.00012', executeCommandsLocally: true, genericHandler: "Zigbee") {
		// capability "Actuator"
		// capability "Configuration"
		// capability "Refresh"
		// capability "Power Meter"
		// capability "Sensor"
		// capability "Switch"
		// capability "Health Check"
		// capability "Light"

		capability "Actuator"
		capability "Configuration"
		capability "Refresh"
		capability "Switch"
		capability "Temperature Measurement"
		capability "Sensor"
		capability "Power Meter"
		capability "Energy Meter"

		attribute "lastCheckin", "string"
		attribute "lastCheckinDate", "String"

		// // Generic
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0B04", deviceJoinName: "Switch"
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0702", deviceJoinName: "Switch"

		// // Aurora
		// fingerprint profileId: "0104", inClusters: "0000, 0702, 0003, 0009, 0B04, 0006, 0004, 0005, 0002", outClusters: "0000, 0019, 000A, 0003, 0406", manufacturer: "Develco Products A/S", model: "Smart16ARelay51AU", deviceJoinName: "Aurora Switch" //Aurora Smart Inline Relay
		// fingerprint profileId: "0104", inClusters: "0000, 0702, 0003, 0009, 0B04, 0006, 0004, 0005, 0002", outClusters: "0000, 0019, 000A, 0003, 0406", manufacturer: "Aurora", model: "Smart16ARelay51AU", deviceJoinName: "Aurora Switch" //Aurora Smart Inline Relay

		// // EZEX
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0006, 0B04, 0702", outClusters: "0019", model: "E210-KR210Z1-HA", deviceJoinName: "eZEX Switch" //EZEX Plug

		// // GE/Jasco
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0702, 0B05", outClusters: "0003, 000A, 0019", manufacturer: "Jasco Products", model: "45853", deviceJoinName: "GE Outlet", ocfDeviceType: "oic.d.smartplug" //GE ZigBee Plug-In Switch
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0702, 0B05", outClusters: "000A, 0019", manufacturer: "Jasco Products", model: "45856", deviceJoinName: "GE Switch" //GE ZigBee In-Wall Switch

		// // INGENIUM
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0B04", outClusters: "0000, 0004", manufacturer: "MEGAMAN", model: "SH-PSUKC44B-E", deviceJoinName: "INGENIUM Outlet", ocfDeviceType: "oic.d.smartplug" //INGENIUM ZB Smart Power Adaptor

		// // Ozom
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0702", outClusters: "0000", manufacturer: "ClimaxTechnology", model: "PSM_00.00.00.35TC", deviceJoinName: "Ozom Outlet", ocfDeviceType: "oic.d.smartplug" //Ozom Smart Plug

		// // Philio
		// fingerprint manufacturer: " ", model: "PAN18-v1.0.7", deviceJoinName: "Philio Outlet", ocfDeviceType: "oic.d.smartplug" //profileId: "0104", inClusters: "0000, 0003, 0006, 0702", outClusters: "0003, 0019", //Philio Smart Plug

		// // Salus
		// fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0702", manufacturer: "SALUS", model: "SX885ZB", deviceJoinName: "Salus Switch" //Salus miniSmartplug
        
		// //AduroSmart
		// fingerprint profileId: "0104", deviceId: "0051", inClusters: "0000, 0003, 0004, 0005, 0006, 0B04, 1000, 0702", outClusters: "0019", manufacturer: "AduroSmart Eria", model: "AD-SmartPlug3001", deviceJoinName: "Eria Switch" //Eria Zigbee Smart Plug
		// fingerprint profileId: "0104", deviceId: "010A", inClusters: "0000, 0003, 0004, 0005, 0006, 1000", outClusters: "0019", manufacturer: "AduroSmart Eria", model: "BPU3", deviceJoinName: "Eria Switch" //Eria Zigbee On/Off Plug
		// fingerprint profileId: "0104", deviceId: "0101", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 1000", outClusters: "0019", manufacturer: "AduroSmart Eria", model: "BDP3001", deviceJoinName: "Eria Switch" //Eria Zigbee Dimmable Plug
	}

	tiles(scale: 2) {
		multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "on", label:'${name}', action:"switch.off", icon:"st.switches.switch.on", backgroundColor:"#00A0DC", nextState:"turningOff"
				attributeState "off", label:'${name}', action:"switch.on", icon:"st.switches.switch.off", backgroundColor:"#ffffff", nextState:"turningOn"
				attributeState "turningOn", label:'${name}', action:"switch.off", icon:"st.switches.switch.on", backgroundColor:"#00A0DC", nextState:"turningOff"
				attributeState "turningOff", label:'${name}', action:"switch.on", icon:"st.switches.switch.off", backgroundColor:"#ffffff", nextState:"turningOn"
			}
			tileAttribute ("power", key: "SECONDARY_CONTROL") {
				attributeState "power", label:'${currentValue} W'
			}
		}
		standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		main "switch"
		details(["switch", "refresh"])
	}
}

// Parse incoming device messages to generate events
// def parse(String description) {
// 	log.debug "description is $description"
// 	def event = zigbee.getEvent(description)
// 	if (event) {
// 		if (event.name == "power") {
// 			def powerValue
// 			def div = device.getDataValue("divisor")
// 			div = div ? (div as int) : 10
// 			powerValue = (event.value as Integer)/div
// 			sendEvent(name: "power", value: powerValue)
// 		}
// 		else {
// 			sendEvent(event)
// 		}
// 	}
// 	else {
// 		log.warn "DID NOT PARSE MESSAGE for description : $description"
// 		log.debug zigbee.parseDescriptionAsMap(description)
// 	}
// }

// Parse incoming device messages to generate events
def parse(String description) {
	log.debug "${device.displayName}: Parsing message: '${description}'"
	def value = zigbee.parse(description)?.text
	log.debug "${device.displayName}: Zigbee parse value: $value"
	Map map = [:]

	// Determine current time and date in the user-selected date format and clock style
	def now = formatDate()
	def nowDate = new Date(now).getTime()

	// The receipt of any message results in a lastCheckin (heartbeat) event
	sendEvent(name: "lastCheckin", value: now, displayed: false)
	sendEvent(name: "lastCheckinDate", value: nowDate, displayed: false)

	if (description?.startsWith('catchall:')) {
		map = parseCatchAllMessage(description)
	}
	else if (description?.startsWith('read attr -')) {
		map = parseReportAttributeMessage(description)
	}
	else if (description?.startsWith('on/off: ')){
		map = parseCustomMessage(description)
	}

	if (map) {
		log.debug "${device.displayName}: Creating event ${map}"
		return createEvent(map)
	} else
		return [:]
}

private Map parseCatchAllMessage(String description) {
	Map resultMap = [:]
	def zigbeeParse = zigbee.parse(description)
	log.debug "${device.displayName}: Catchall parsed as $cluster"

	if (zigbeeParse.clusterId == 0x0006 && zigbeeParse.command == 0x01){
		def onoff = zigbeeParse.data[-1]
		if (onoff == 1)
			resultMap = createEvent(name: "switch", value: "on")
		else if (onoff == 0)
			resultMap = createEvent(name: "switch", value: "off")
	}
	return resultMap
}

private Map parseReportAttributeMessage(String description) {
	Map descMap = (description - "read attr - ").split(",").inject([:]) {
		map, param ->
		def nameAndValue = param.split(":")
		map += [(nameAndValue[0].trim()):nameAndValue[1].trim()]
	}

	Map resultMap = [:]

	if (descMap.cluster == "0001" && descMap.attrId == "0020") {
		resultMap = getBatteryResult(convertHexToInt(descMap.value / 2))
	}
	if (descMap.cluster == "0002" && descMap.attrId == "0000") {
		def tempScale = getTemperatureScale()
		def tempValue = zigbee.parseHATemperatureValue("temperature: " + (convertHexToInt(descMap.value) / 2), "temperature: ", tempScale) + (tempOffset ? tempOffset : 0)
		resultMap = createEvent(name: "temperature", value: tempValue, unit: tempScale, translatable: true)
		log.debug "${device.displayName}: Reported temperature is ${resultMap.value}°$tempScale"
	}
	else if (descMap.cluster == "0008" && descMap.attrId == "0000") {
		resultMap = createEvent(name: "switch", value: "off")
	}
	else if (descMap.cluster == "000C" && descMap.attrId == "0055" && descMap.endpoint == "02") {
		def wattage_int = Long.parseLong(descMap.value, 16)
		def wattage = Float.intBitsToFloat(wattage_int.intValue())
		wattage = Math.round(wattage * 10) * 0.1
		resultMap = createEvent(name: "power", value: wattage, unit: 'W')
		log.debug "${device.displayName}: Reported power use is ${wattage}W"
	}
	else if (descMap.cluster == "000C" && descMap.attrId == "0055" && descMap.endpoint == "03") {
		def energy_int = Long.parseLong(descMap.value, 16)
		def energy = Float.intBitsToFloat(energy_int.intValue())
		energy = Math.round(energy * 100) * 0.0001
		resultMap = createEvent(name: "energy", value: energy, unit: 'kWh')
		log.debug "${device.displayName}: Reported energy usage is ${energy}kWh"
	}
	return resultMap
}

def off() {
	zigbee.off()
}

def on() {
	zigbee.on()
}

def refresh() {
	Integer reportIntervalMinutes = 5
	def cmds = zigbee.onOffRefresh() + zigbee.simpleMeteringPowerRefresh() + zigbee.electricMeasurementPowerRefresh()
	if (device.getDataValue("manufacturer") == "Jasco Products") {
		// Some versions of hub firmware will incorrectly remove this binding causing manual control of switch to stop working
		// This needs to be the first binding table entry because the device will automatically write this entry each time it restarts
		cmds += ["zdo bind 0x${device.deviceNetworkId} 2 1 0x0006 {${device.zigbeeId}} {${device.zigbeeId}}", "delay 2000"]
	}
	cmds + zigbee.onOffConfig(0, reportIntervalMinutes * 60) + zigbee.simpleMeteringPowerConfig() + zigbee.electricMeasurementPowerConfig()
}

def configure() {
	log.debug "in configure()"
	if ((device.getDataValue("manufacturer") == "Develco Products A/S") || (device.getDataValue("manufacturer") == "Aurora"))  {
		device.updateDataValue("divisor", "1")
	}
	if (device.getDataValue("manufacturer") == "SALUS") {
		device.updateDataValue("divisor", "1")
	}
	return configureHealthCheck()
}

def configureHealthCheck() {
	Integer hcIntervalMinutes = 12
	sendEvent(name: "checkInterval", value: hcIntervalMinutes * 60, displayed: false, data: [protocol: "zigbee", hubHardwareId: device.hub.hardwareID])
	return refresh()
}

def updated() {
	log.debug "in updated()"
	// updated() doesn't have it's return value processed as hub commands, so we have to send them explicitly
	def cmds = configureHealthCheck()
	cmds.each{ sendHubCommand(new physicalgraph.device.HubAction(it)) }
}

def ping() {
	return zigbee.onOffRefresh()
}

def formatDate() {
	def correctedTimezone = ""
	def timeString = clockformat ? "HH:mm:ss" : "h:mm:ss aa"

	// If user's hub timezone is not set, display error messages in log and events log, and set timezone to GMT to avoid errors
	if (!(location.timeZone)) {
		correctedTimezone = TimeZone.getTimeZone("GMT")
		log.error "${device.displayName}: Time Zone not set, so GMT was used. Please set up your location in the SmartThings mobile app."
		sendEvent(name: "error", value: "", descriptionText: "ERROR: Time Zone not set, so GMT was used. Please set up your location in the SmartThings mobile app.")
	}
	else {
		correctedTimezone = location.timeZone
	}
	if (dateformat == "US" || dateformat == "" || dateformat == null) {
		return new Date().format("EEE MMM dd yyyy ${timeString}", correctedTimezone)
	}
	else if (dateformat == "UK") {
		return new Date().format("EEE dd MMM yyyy ${timeString}", correctedTimezone)
	}
	else {
		return new Date().format("EEE yyyy MMM dd ${timeString}", correctedTimezone)
	}
}