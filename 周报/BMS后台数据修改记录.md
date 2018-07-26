###BMS后台数据修改记录【分支：elastic4s/liangshuai】

#####命令标识单元

|  CommandType  | 命令标识code | 状态 |
| :-----------: | :----------: | :--: |
|   LoginType   |      01      |  1   |
| RealtimeType  |      02      |  1   |
|   QueryType   |      80      |  x   |
| ConfigureType |      82      |  x   |

#####信息类型标识说明

| FrameType                       | 信息类型表示code | 状态 |
| :------------------------------ | :--------------: | :--: |
| PeakValueType                   |        06        |  1   |
| BmuType                         |        30        |  1   |
| VoltData                        |        08        |  1   |
| TemprData                       |        09        |  1   |
| DebugPowerOnData                |        80        |  1   |
| PowerOnData                     |        81        |  1   |
| DeviceList                      |        82        |  1   |
| SysInfo                         |        83        |  1   |
| DtuInfo                         |        84        |  1   |
| ChargingInfo                    |        85        |  1   |
| Balancing                       |        86        |  1   |
| Alarm                           |        87        |  1   |
| CapabilitiesFrameType           |        91        |  1   |
| ConfigureDeviceToSetOtaFlagType |        80        |  1   |
| QueryAppInfoType                |        82        |  1   |

DTU表格中的信息标识对应于 RealtimeType，故BMS后台中即使在FrameType下有相同的code也没事，它们是在不同的大类下面【xlsx表格中，灰色涵盖的表示是之前已经在运行中的，而天蓝色表示的都是将来灰颜色的替代者，但是灰色的也不能去掉，必须兼容】

##### 我给新加的字段

```scala
EleCapacity   0x88 新增充放电容量数据,只解析不存放数据
NewEleCapacity   0x89 新版兼容EleCapacity 周期发送
SocInfo  0x90 新增SOC参数数据,只解析不存放数据
SystemInfo  0x92 新增系统状态 周期发送
NewChargingInfo  0x93 新版兼容ChargingInfo 充电状态下周期发送
```

##### RealtimeType下的信息类型【都是无符号的】

| 字段                  | 对应的信息                              |      |
| --------------------- | --------------------------------------- | ---- |
| PeakValueType         | 极值数据 周期发送                       |      |
| VoltData              | 可储能装置电压数据 周期发送             |      |
| TemprData             | 可储能装置温度数据                      |      |
| PowerOnData           | 设备信息 登录成功之后发送1次            |      |
| DeviceList            | 设备列表 登录成功之后发送1次            |      |
| SysInfo               | 系统状态 周期发送                       |      |
| DtuInfo               | DTU状态信息数据 周期发送                |      |
| ChargingInfo          | 充电状态数据 充电状态下周期发送         |      |
| Balancing             | 均衡状态数据 充电状态下周期发送         |      |
| Alarm                 | 报警状态数据 周期发送                   |      |
| EleCapacity           | 新增充放电容量数据,只解析不存放数据     |      |
| NewEleCapacity        | 新版兼容EleCapacity 周期发送            |      |
| SocInfo               | 新增SOC参数数据,只解析不存放数据        |      |
| CapabilitiesFrameType | 设备信息 登录成功之后发送1次            |      |
| SystemInfo            | 新增系统状态 周期发送                   |      |
| NewChargingInfo       | 新版兼容ChargingInfo 充电状态下周期发送 |      |

在passera.unsigned包中，定义了所有的无符号的类型前面加 uInt、UShort等，如果是有符号转化为无符号

a.getInt().toUInt()类似

##### 可能是0x93匹配出错

在解析第24位时，出错， 9a错误的解析成了124    9a应该是154

[^author：梁帅]: 

