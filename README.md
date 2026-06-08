# Copper Bulb Ealy
[![GitHub Releases](https://shields.io/github/v/release/chenjunfu2/copper-bulb-early-1.20.1)](https://github.com/chenjunfu2/copper-bulb-early-1.20.1/releases)
[![GitHub Releases downloads](https://shields.io/github/downloads/chenjunfu2/copper-bulb-early-1.20.1/total)](https://github.com/chenjunfu2/copper-bulb-early-1.20.1/releases)
[![GitHub Repo stars](https://shields.io/github/stars/chenjunfu2/copper-bulb-early-1.20.1)](https://github.com/chenjunfu2/copper-bulb-early-1.20.1)  
这是一个将 **``Minecraft 1.21.4 铜灯(Copper Bulb)``**![icon.png](src/main/resources/assets/minecraft/textures/block/copper_bulb_lit.png) 完美移植到 **``Minecraft 1.20.1``** 的模组，将铜灯完整特性与成就带回 **``Minecraft 1.20.1``** 。  
因为mod使用了原版名称空间和数据格式，所以可以与Litematica Mod读取的高版本投影内的铜灯兼容，同时升级存档也能被高版本识别并保留。  

## 说明
这个项目由[Rczlin-bulb-early-1.20.1](https://github.com/Rczlin/bulb-early-1.20.1)修改而来  

**相比原先的移植mod：**
- 修复铜灯不能受到随机刻事件氧化的问题
- 修复资源文件为原版名称空间以兼容资源包
- 新增所有铜灯变种的移植
- 新增相关进度的移植

## 环境要求
**游戏版本**：**``Minecraft 1.20.1``**  
**加载器版本**：**``Fabric 0.14.22+``**  
**Fabric API**: **``0.92.3+``** （自0.92.3版本起，修复了一个可能导致此模组出现问题的bug）  
**多人游戏**：**``服务端``** 与 **``客户端``** 均必须安装  
**单人游戏**：仅需 **``客户端``** 安装   

## 不兼容问题
- **BBOR（Bounding Box Outline Reloaded）** – 该模组存在一个严重 bug，会导致本模组方块的挖掘时间异常增加，并可能导致方块被破坏时不掉落任何物品。由于BBOR 已不再维护，因此此不兼容问题将不会得到修复。  
  
## 注意
- 如果仅在服务器安装而客户端未安装，连接此服务器时会出现 **“模组缺失”** 或 **“方块ID无法解析”** 等问题。  
- 如果仅在客户端安装，**可以正常进入未安装此Mod的服务器** （在此服务器中客户端Mod方块不生效）。   

## Star History
[![Star History Chart](https://api.star-history.com/image?repos=chenjunfu2/copper-bulb-early-1.20.1&type=date&legend=top-left)](https://www.star-history.com/?repos=chenjunfu2%2Fcopper-bulb-early-1.20.1&type=date&legend=top-left)  
