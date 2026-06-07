# Java 设计模式详解教程

## 📚 项目简介

本项目是一个全面的Java设计模式学习资源，涵盖了GoF（Gang of Four）设计模式中的23种经典模式。每种模式都提供了完整的代码实现、详细的解释说明以及实际的业务应用场景，旨在帮助开发者深入理解和掌握设计模式的精髓。

## 🎯 学习目标

- 理解设计模式的核心思想和解决的问题
- 掌握每种模式的结构和实现方式
- 能够在实际项目中正确应用设计模式
- 提高代码的可维护性、可扩展性和复用性

## 🔧 项目结构说明

```
src/
├── patterns/                          # 根包
│   ├── package-info.java
│   ├── creational/                    # 创建型模式
│   │   ├── package-info.java
│   │   ├── factory/                   # 工厂模式族
│   │   │   ├── simple/                #   简单工厂模式
│   │   │   ├── method/                #   工厂方法模式 ⭐⭐⭐
│   │   │   └── abstract_factory/      #   抽象工厂模式
│   │   ├── builder/                   #   建造者模式 ⭐⭐
│   │   ├── singleton/                 #   单例模式 ⭐⭐
│   │   └── prototype/                 #   原型模式
│   ├── structural/                    # 结构型模式
│   │   ├── package-info.java
│   │   ├── adapter/                   #   适配器模式 ⭐
│   │   ├── bridge/                    #   桥接模式
│   │   ├── composite/                 #   组合模式
│   │   ├── decorator/                 #   装饰模式 ⭐⭐
│   │   ├── proxy/                     #   代理模式 ⭐⭐⭐
│   │   │   └── jdk/                   #     JDK动态代理
│   │   ├── facade/                    #   外观模式
│   │   └── flyweight/                 #   享元模式
│   └── behavioral/                    # 行为型模式
│       ├── package-info.java
│       ├── interpreter/               #   解释器模式
│       ├── template_method/           #   模板方法模式 ⭐
│       ├── chain_of_responsibility/   #   责任链模式 ⭐⭐
│       ├── command/                   #   命令模式 ⭐
│       ├── iterator/                  #   迭代器模式
│       ├── mediator/                  #   中介者模式
│       ├── memento/                   #   备忘录模式
│       ├── observer/                  #   观察者模式 ⭐⭐
│       ├── state/                     #   状态模式 ⭐
│       ├── strategy/                  #   策略模式 ⭐⭐⭐
│       └── visitor/                   #   访问者模式
```

> **⭐ 重点标记说明**  
> 以下 12 个模式按重要程度分为三级，建议优先掌握 ⭐⭐⭐ 级别：
>
> | 级别 | 模式 | 为何重要 |
> | :---: | :--- | :--- |
> | ⭐⭐⭐ | **工厂方法模式** | Spring IOC 容器核心思想，几乎所有框架都用 |
> | ⭐⭐⭐ | **代理模式** | Spring AOP 的核心，JDK/CGLIB 动态代理必考 |
> | ⭐⭐⭐ | **策略模式** | 消除大量 if-else 的标准答案，Java 8 函数式接口简化后更常用 |
> | ⭐⭐ | **建造者模式** | 解决参数爆炸问题，Lombok `@Builder` 就是它的实现 |
> | ⭐⭐ | **单例模式** | 保证全局唯一实例，数据库连接池、日志管理器都在用 |
> | ⭐⭐ | **装饰模式** | Java IO 流的底层设计，AOP 切面编程的基础 |
> | ⭐⭐ | **责任链模式** | 审批流、过滤器链、异常处理链的通用解法 |
> | ⭐⭐ | **观察者模式** | 事件驱动架构的基础，Spring Event 就是它的实现 |
> | ⭐ | **适配器模式** | 新旧系统对接、第三方 SDK 集成的必备手段 |
> | ⭐ | **命令模式** | GUI 操作、任务调度、撤销重做功能的标准解法 |
> | ⭐ | **模板方法模式** | 框架Hook点设计的标准套路 |
> | ⭐ | **状态模式** | 状态机场景的首选，订单状态、游戏角色状态管理等 |

## 📖 设计原则基础

在学习具体的设计模式之前，我们需要先了解面向对象设计的各项原则，这些原则是设计模式的理论基础。

设计原则按层次可以分为三个层级：

- **SOLID 五大核心原则**：类级别的设计标准，最广为人知
- **GRASP 职责分配原则**：解决"这个职责该分配给谁"这一更根本的问题
- **架构级原则**：模块和包级别的依赖方向、稳定性约束

### 一、SOLID 五大核心原则

#### 1. 单一职责原则 (SRP)

**定义**: 一个类应该只有一个引起它变化的原因，即一个类只负责一项职责。

**核心思想**: 高内聚，每个类专注做好一件事。

**理解难点**:
- 如何判断职责的边界？
- 过度拆分会导致类爆炸，如何平衡？

**业务场景**: 用户管理类只负责用户相关操作，不处理订单或支付逻辑。

#### 2. 开闭原则 (OCP)

**定义**: 软件实体应当对扩展开放，对修改关闭。

**核心思想**: 通过抽象化实现可扩展性，新功能通过添加新代码实现，而不是修改现有代码。

**理解难点**:
- 如何预测未来的变化点？
- 抽象的粒度如何把握？

**业务场景**: 支付系统支持多种支付方式（支付宝、微信、银行卡），新增支付方式时不修改现有代码。

#### 3. 里氏替换原则 (LSP)

**定义**: 子类可以扩展父类的功能，但不能改变父类原有的功能。

**核心思想**: 确保继承关系的正确性，子类对象能够替换父类对象。

**理解难点**:
- 子类重写方法时的前置条件和后置条件约束
- 如何避免破坏父类的契约？

**业务场景**: 所有的数据库操作类都能被其具体实现（MySQL、Oracle、MongoDB）替换。

#### 4. 依赖倒转原则 (DIP)

**定义**: 高层模块不应依赖于底层模块，它们都应该依赖抽象。

**核心思想**: 面向接口编程，减少类间的耦合度。

**理解难点**:
- 如何识别高层模块和底层模块？
- 依赖注入的最佳实践

**业务场景**: 业务逻辑层不直接依赖具体的数据访问层实现，而是依赖数据访问接口。

#### 5. 接口隔离原则 (ISP)

**定义**: 客户端不应依赖那些它不需要的接口。

**核心思想**: 接口应该小而专一，避免胖接口。

**理解难点**:
- 接口拆分的粒度如何控制？
- 如何避免接口爆炸？

**业务场景**: 管理员接口和普通用户接口分离，普通用户不需要访问管理功能。

---

### 二、GRASP 职责分配原则（9种）

GRASP 是 Craig Larman 在《Applying UML and Patterns》中提出的一套职责分配原则，解决的核心问题是：**这个职责应该分配给哪个类？** 它比 SOLID 更底层，直接指导类设计的每一个决策。

#### 1. 信息专家原则 (Information Expert)

**定义**: 将职责分配给持有完成该职责所需最完整信息的类。

**核心思想**: 信息在哪里，职责就在哪里。如果一个类拥有执行某个操作所需的数据，那么这个类就应该负责执行这个操作。

**理解难点**:
- 如何判断哪个类"拥有最相关的信息"？
- 信息可能分散在多个类中时如何处理？

**业务场景**: 订单类持有商品列表和数量信息，因此"计算订单总价"的职责应该分配给订单类，而不是外部服务。

#### 2. 创建者原则 (Creator)

**定义**: 将创建类 B 实例的职责分配给类 A，当满足以下任一条件时：
- A 包含 B 的实例（聚合关系）
- A 记录 B 的实例
- A 密切使用 B 的实例
- A 拥有初始化 B 实例所需的数据

**核心思想**: 谁拥有数据，谁就负责创建对象。

**理解难点**:
- 聚合关系和组合关系的区分
- 创建职责过多时如何避免创建者类过于臃肿

**业务场景**: 订单（Order）包含多个订单项（OrderItem），订单类负责创建订单项对象。

#### 3. 控制器原则 (Controller)

**定义**: 将处理系统事件的职责分配给一个代表整个系统的控制器类（或一个代表某个用例场景的控制器）。

**核心思想**: 把事件处理的入口集中在一个控制器中，避免业务逻辑散落在 UI 层。

**理解难点**:
- 控制器的粒度：是整个系统一个，还是每个用例场景一个？
- 如何避免控制器变成上帝类？

**业务场景**: Spring MVC 中的 `@RestController` 就是典型的控制器角色，接收请求、委派给 Service 处理、返回响应。

#### 4. 低耦合原则 (Low Coupling)

**定义**: 分配职责时应尽量减少类之间的依赖关系。

**核心思想**: 耦合度越低，一个类的修改对系统其他部分的影响就越小。通过依赖抽象、接口隔离、事件驱动等方式降低耦合。

**理解难点**:
- 完全解耦是不可能的，如何把握耦合的合理程度？
- 解耦过度会导致间接层过多，反而增加理解成本

**业务场景**: 业务层通过接口调用数据访问层，不直接依赖具体实现，替换数据库时只需更改配置。

#### 5. 高内聚原则 (High Cohesion)

**定义**: 分配职责时应保证一个类内部的职责高度相关。

**核心思想**: 高内聚的类更容易理解和维护，因为所有职责都围绕同一个主题。与单一职责原则一脉相承，但 GRASP 强调"相关的职责"而非"单一的职责"——一个类可以有一组相关的小职责。

**理解难点**:
- "相关"的判定标准是什么？
- 如何识别不相关的职责被放在了同一个类中？

**业务场景**: 一个 `EmailService` 类同时负责邮件格式化和邮件发送，这两个职责相关，内聚合理；但如果它还负责用户数据校验，就属于内聚不足。

#### 6. 多态原则 (Polymorphism)

**定义**: 使用多态操作来替代基于类型的条件判断，将行为变化封装到继承层次结构中。

**核心思想**: 当行为依赖于对象类型时，不要用 `if-else` 或 `switch` 判断类型，而是定义接口，让每个类型提供自己的实现。

**理解难点**:
- 何时该用多态？何时简单的条件判断就够了？
- 过度使用多态会增加继承层次，如何平衡？

**业务场景**: 不同支付方式（支付宝、微信、银行卡）的扣款逻辑不同，定义 `PaymentProcessor` 接口，每种支付方式提供自己的实现，调用方无需关心具体类型。

#### 7. 纯虚构原则 (Pure Fabrication)

**定义**: 人为创建一个在现实领域中没有对应概念的类，来承担一些高内聚的职责，从而避免把职责分配给那些不合适的现有类。

**核心思想**: 不是所有的类都能对应现实中的概念。有些类纯粹是为了技术实现而存在（比如 `SessionManager`、`ConnectionPool`），它们是对现实世界的"虚构"。

**理解难点**:
- 虚构类的数量不能太多，否则领域模型会被淹没
- 虚构类和领域类的界限如何划分？

**业务场景**: 现实中不存在"连接池"这个概念，但在代码中创建一个 `DataSource` 类来管理数据库连接，就是纯虚构——它服务于技术需求，而非业务需求。

#### 8. 间接原则 (Indirection)

**定义**: 将职责分配给中间对象，以避免两个或多个类之间产生直接耦合。中间对象在两个组件之间起到协调作用。

**核心思想**: 中间人负责协调，避免 A 直接依赖 B。常见的间接方式包括委托、回调、事件总线、消息队列等。

**理解难点**:
- 间接层过多会增加系统复杂度，如何取舍？
- 中间类本身如何保持高内聚、低耦合？

**业务场景**: A 业务模块不直接调用 B 模块，而是通过 `EventBus` 发布事件，B 模块订阅事件后自行处理，两者互不知晓对方的存在。

#### 9. 受保护变化原则 (Protected Variations)

**定义**: 识别系统中不稳定或可能变化的部分，用稳定的接口或抽象来隔离这些变化点。

**核心思想**: 这是开闭原则的另一种表述，但更强调"主动识别变化点"这个动作。在设计初期就要预判哪些地方容易变，并用抽象保护起来。

**理解难点**:
- 如何准确预判哪些是"不稳定"的部分？过度保护会导致设计冗余
- 变化点可能在多个维度上（支付渠道、数据格式、第三方接口），如何设计合适的抽象层级？

**业务场景**: 对接多个第三方短信服务商（阿里云、腾讯云、华为云），预判"服务商可能切换"这个变化点，定义统一的 `SmsSender` 接口，切换服务商时只需更换实现。

---

### 三、额外设计原则

以上是 SOLID（5种）和 GRASP（9种），共 14 种。除此之外，还有一些在工程实践中被广泛引用的原则：

#### 1. 组合/聚合复用原则 (CRP)

**定义**: 优先使用对象组合，而不是通过继承来达到复用的目的。

**核心思想**: 通过组合/聚合关系来实现代码复用。继承是一种强耦合关系，而组合是一种灵活的、运行时可变的关联方式。

**理解难点**:
- 何时使用继承？何时使用组合？
- 如何设计组合关系？

**业务场景**: 汽车类通过组合引擎、轮胎等部件，而不是继承它们。

#### 2. 迪米特法则 (LoD / 最少知识原则)

**定义**: 一个对象应该对其他对象保持最少的了解。一个类只和其"朋友"类通信，不与非朋友类通信。

**核心思想**: 减少对象间的耦合，只与直接的朋友（出现在成员变量、方法参数、方法返回值中的类）通信，避免"链式调用"穿透多层。

**理解难点**:
- 如何定义"朋友"关系？
- 如何在解耦和性能之间平衡？

**业务场景**: 订单类不直接访问用户的地址信息，而是通过用户类提供的方法获取。

#### 3. DRY 原则（Don't Repeat Yourself）

**定义**: 系统中的每一部分知识都应该有单一、明确和权威的表示。

**核心思想**: 不要重复写相同的代码或逻辑。重复的代码一旦需要修改，必须在所有重复的地方同步修改，容易遗漏。

**理解难点**:
- 什么程度的重复才需要提取？表面相似的代码可能业务意图不同
- 过度抽象会导致代码更难理解

**业务场景**: 多个模块都需要做"手机号格式校验"，提取为公共工具方法，而不是每个模块各写一遍。

#### 4. KISS 原则（Keep It Simple, Stupid）

**定义**: 系统设计应该尽可能简单，不要引入不必要的复杂度。

**核心思想**: 简单方案往往比复杂方案更可靠、更易维护。能用一行代码解决的问题不要写五层抽象。

**理解难点**:
- 如何判断什么是"不必要的复杂度"？
- 扩展性和简单性之间如何取舍？

**业务场景**: 一个简单的参数校验用 `if` 判断就够了，不需要为此设计一套完整的校验框架和注解体系。

#### 5. YAGNI 原则（You Aren't Gonna Need It）

**定义**: 只实现当前需要功能，不要提前实现你"觉得将来可能需要"的功能。

**核心思想**: 未来是不确定的，为不存在的需求编写代码是在浪费时间。当需求真的到来时，往往发现预想的方案并不适用。

**理解难点**:
- 如何区分"合理的前瞻性设计"和"过度设计"？
- 某些基础设施（如日志、监控）是否属于 YAGNI 的例外？

**业务场景**: 项目初期只需要支持支付宝一种支付方式，不要提前为"将来可能加微信支付"设计一套复杂的策略工厂。等真的加微信支付时，再重构也不迟。

#### 6. SLAP 原则（Single Level of Abstraction Principle）

**定义**: 一个方法中的语句应该处于同一抽象层级。

**核心思想**: 一个方法里不要同时出现"业务逻辑"和"底层细节"。要么方法中的每一行都是高层次的业务描述，要么每一行都是底层的技术操作。

**理解难点**:
- 抽象层级的边界如何划定？
- 过度分层会导致方法碎片化

**业务场景**: 一个 `processOrder` 方法中，如果调用了 `validateOrder`、`calculateTotal`、`saveToDatabase`，这是 OK 的（同一层级）；但如果方法体中又出现了 SQL 拼接和 JDBC 调用的细节，就违反了 SLAP。

---

### 四、架构级原则

这些原则更偏向于模块和包级别的架构设计，指导项目结构和依赖方向。

#### 1. 好莱坞原则（Hollywood Principle）

**定义**: "别调用我们，我们会调用你"（Don't call us, we'll call you）。

**核心思想**: 高层框架/基础设施调用低层业务代码，而不是反过来。低层模块（业务代码）向高层框架（如 Spring）注册自己，框架在适当的时机回调。

**理解难点**:
- 如何区分"谁调用谁"的责任边界？
- 回调地狱和过度设计的问题

**业务场景**: Spring 的依赖注入——你定义了 Bean，Spring 容器在启动时创建并注入它，你不用手动 `new`。

#### 2. 无环依赖原则（ADP）

**定义**: 包的依赖关系图中不能存在环（循环依赖）。

**核心思想**: 如果 A 依赖 B，B 又依赖 A（直接或间接），那么这两个包就无法独立测试、独立部署，而且一个微小的修改可能导致连锁反应。

**理解难点**:
- 大型项目中如何发现隐藏的循环依赖？
- 打破循环依赖的常用手段（抽取公共接口、事件驱动、依赖注入）

**业务场景**: `order-service` 依赖 `user-service`，同时 `user-service` 又调用了 `order-service` 的接口——这就构成了循环依赖。解决方法是提取公共接口到 `common-api` 模块。

#### 3. 稳定依赖原则（SDP）

**定义**: 依赖的方向应该朝向更稳定的方向。稳定的模块应该被更多模块依赖，而不稳定的模块应该依赖更稳定的模块。

**核心思想**: 你依赖的东西越稳定，你的系统就越不容易被外部变化冲击。抽象层（接口）通常是稳定的，具体实现层是频繁变化的，所以依赖方向应该是 具体 → 抽象。

**理解难点**:
- 如何衡量一个模块的"稳定性"？（修改频率、被依赖数量）
- 实际项目中，底层工具库往往更稳定，但业务层又必须依赖它们，如何平衡？

**业务场景**: 业务服务层依赖接口定义层（稳定），具体实现通过依赖注入在运行时提供（易变）。接口定义层不依赖任何业务实现。

#### 4. 稳定抽象原则（SAP）

**定义**: 一个模块的抽象程度应该与其稳定性成正比。稳定的模块应该是抽象的（包含接口和抽象类），不稳定的模块应该是具体的（包含实现细节）。

**核心思想**: 如果一个模块非常稳定（几乎不变），那它应该以接口的形式存在，供其他模块依赖。如果不稳定的模块反而依赖具体实现，就会把变化传导出去。

**理解难点**:
- SAP 和 SDP 是一体两面，如何结合使用？
- "抽象"和"稳定"的判定标准是什么？

**业务场景**: 支付接口定义层（`PaymentApi`）是高度抽象且稳定的，支付的具体实现（AlipayImpl、WechatImpl）是具体的且容易变化的。

#### 5. 共同闭包原则（CCP）

**定义**: 那些需要同时被修改的类应该放在同一个包/模块中。一个包应该只因为同一种原因而改变。

**核心思想**: 将因同一原因而变化的类放在一起，这样修改时只需要修改一个模块，而不是散落在多个地方。

**理解难点**:
- "同一原因"如何判定？变更往往以意外的方式出现
- 和单一职责原则的关系：CCP 是包级别的 SRP

**业务场景**: 所有与订单流程相关的类（`Order`、`OrderValidator`、`OrderRepository`、`OrderEvent`）放在 `order` 包中，当订单逻辑变更时，只需要修改这一个包。

#### 6. 共同复用原则（CRP）

**定义**: 一起复用的类应该一起打包。不要强迫不相关的类因为某个类被依赖而被迫一起引入。

**核心思想**: 一个包中的类应该被作为一个整体一起复用。如果只用到了包中的一部分，说明这个包应该被拆分。

**理解难点**:
- 如何判断哪些类"总是一起被复用"？
- 过度拆分会导致碎片化，不拆又会导致冗余引入

**业务场景**: 一个 `spring-web` 依赖了 `spring-core`，即使你的代码只用到了 `spring-core` 中的一小部分，你也必须引入整个包——这就是 CRP 的实际体现（框架层面的 CRP）。

---

### 五、原则关系总结

```
架构层（包/模块级）：
  ADP（无环依赖） → SDP（稳定依赖方向） → SAP（稳定即抽象）
  CCP（共同闭包） → CRP（共同复用）

类级别（SOLID + 扩展）：
  SRP + OCP + LSP + DIP + ISP  → SOLID 核心
  CRP（组合复用） + LoD（迪米特）  → 补充

职责分配（GRASP）：
  Information Expert + Creator + Controller + Low Coupling + High Cohesion
  + Polymorphism + Pure Fabrication + Indirection + Protected Variations

工程实践：
  DRY + KISS + YAGNI + SLAP + Rule of Three
```

> **🎯 学习建议**: 对于日常编码，SOLID 5 种 + 迪米特 + GRASP 的"信息专家"和"低耦合高内聚"是最实用的核心。DRY / KISS / YAGNI 是代码审查时最常用的三个判断标准。架构级原则在设计和评审项目结构时参考。

---

## 🏭 创建型模式 (Creational Patterns)

创建型模式关注对象的创建过程，将对象的创建与使用分离，提高系统的灵活性和可维护性。

### 1. 简单工厂模式 (Simple Factory)

**📍 位置**: [`src/patterns/creational/factory/simple/package-info.java`](src/patterns/creational/factory/simple/package-info.java)

**模式说明**: 
简单工厂模式通过一个工厂类来创建各种产品对象，客户端不需要知道具体产品类的创建逻辑。

**代码结构分析**:
```java
// 抽象产品接口
public interface Logger {
    void log(String message);
}

// 具体产品：文件日志记录器
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // 将日志写入文件
    }
}

// 具体产品：控制台日志记录器
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

// 工厂类：根据类型字符串决定创建哪种日志记录器
public class LoggerFactory {
    public static Logger getLogger(String type) {
        switch (type) {
            case "FILE":    return new FileLogger();
            case "CONSOLE": return new ConsoleLogger();
            default: throw new IllegalArgumentException("不支持的日志类型: " + type);
        }
    }
}

// 客户端使用
Logger logger = LoggerFactory.getLogger("CONSOLE");
logger.log("系统启动成功");
```

**💡 理解难点**:
1. **职责边界**: 简单工厂承担了所有产品的创建逻辑，违反了开闭原则
2. **扩展性**: 新增产品类型需要修改工厂类代码
3. **静态工厂 vs 实例工厂**: 何时使用静态方法？何时使用实例方法？

**🎯 业务应用场景**:
- **日志记录器**: 根据配置创建不同类型的日志记录器（文件、数据库、控制台）
- **数据库连接**: 根据配置创建不同数据库的连接对象
- **消息推送**: 根据平台类型创建不同的推送服务（iOS、Android、Web）

**优缺点分析**:
- ✅ 客户端无需知道具体产品类名
- ✅ 实现了对象创建和使用的分离
- ❌ 工厂类职责过重，违反单一职责原则
- ❌ 新增产品需要修改工厂类，违反开闭原则

### 2. 工厂方法模式 ⭐⭐⭐ (Factory Method)

**📍 位置**: [`src/patterns/creational/factory/method/package-info.java`](src/patterns/creational/factory/method/package-info.java)

**模式说明**: 
工厂方法模式定义一个创建对象的接口，让子类决定实例化哪一个类。工厂方法让类的实例化推迟到子类。

**代码结构分析**:
```java
// 抽象产品接口
public interface PaymentProcessor {
    void process(double amount);
}

// 具体产品：支付宝处理器
public class AlipayProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("支付宝支付: " + amount + " 元");
    }
}

// 具体产品：微信支付处理器
public class WechatPayProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("微信支付: " + amount + " 元");
    }
}

// 抽象工厂接口：定义一个创建 PaymentProcessor 的方法
public interface PaymentProcessorFactory {
    PaymentProcessor createProcessor();
}

// 具体工厂：支付宝工厂
public class AlipayFactory implements PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new AlipayProcessor();
    }
}

// 具体工厂：微信支付工厂
public class WechatPayFactory implements PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new WechatPayProcessor();
    }
}

// 客户端使用（不关心具体创建哪个处理器，只需拿到工厂即可）
PaymentProcessor processor = new AlipayFactory().createProcessor();
processor.process(100.0);
```

**💡 理解难点**:
1. **抽象层次**: 如何设计工厂接口的抽象层次？
2. **参数化工厂**: 通过参数控制创建逻辑的设计考量
3. **类型安全**: 字符串参数容易出错，如何改进？

**🎯 业务应用场景**:
- **支付处理**: 不同的支付工厂创建对应的支付处理器
- **文档解析**: 根据文件类型创建相应的解析器（PDF、Word、Excel）
- **图片处理**: 根据图片格式创建对应的处理器

### 3. 抽象工厂模式 (Abstract Factory)

**📍 位置**: [`src/patterns/creational/factory/abstract_factory/package-info.java`](src/patterns/creational/factory/abstract_factory/package-info.java)

**模式说明**: 
抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

**代码结构分析**:
```java
// 抽象产品接口
public interface Phone   { void use(); }
public interface Tablet  { void use(); }
public interface Earbuds { void use(); }

// 抽象工厂接口：创建一整族产品
public interface ElectronicsFactory {
    Phone   createPhone();
    Tablet  createTablet();
    Earbuds createEarbuds();
}

// 具体工厂：小米工厂（保证所有产品风格一致）
public class XiaomiFactory implements ElectronicsFactory {
    @Override public Phone   createPhone()    { return new XiaomiPhone(); }
    @Override public Tablet  createTablet()   { return new XiaomiTablet(); }
    @Override public Earbuds createEarbuds()  { return new XiaomiEarbuds(); }
}

// 具体工厂：苹果工厂
public class AppleFactory implements ElectronicsFactory {
    @Override public Phone   createPhone()    { return new IPhone(); }
    @Override public Tablet  createTablet()   { return new ITablet(); }
    @Override public Earbuds createEarbuds()  { return new IEarbuds(); }
}

// 客户端：一个工厂创建的产品属于同一个"产品族"，风格一致
ElectronicsFactory factory = new XiaomiFactory();
factory.createPhone();   // 小米手机
factory.createTablet();  // 小米平板
```

**💡 理解难点**:
1. **产品族概念**: 理解产品族和产品等级结构的区别
2. **工厂等级结构**: 抽象工厂的继承层次设计
3. **产品一致性**: 如何保证同一工厂创建的产品风格一致？

**🎯 业务应用场景**:
- **UI主题系统**: 不同主题的UI组件工厂（深色主题、浅色主题）
- **数据库访问**: 不同数据库厂商的DAO工厂（MySQL、Oracle、PostgreSQL）
- **操作系统适配**: 不同操作系统的组件工厂（Windows、Mac、Linux）

### 4. 建造者模式 ⭐⭐ (Builder)

**📍 位置**: [`src/patterns/creational/builder/package-info.java`](src/patterns/creational/builder/package-info.java)

**模式说明**: 
建造者模式将复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。

**代码结构分析**:
```java
public class Order {
    // 所有字段私有，只能通过 Builder 构建
    private final String userId;
    private final String productId;
    private final int quantity;
    private final String address;
    private final String remark;
    private final String couponCode;

    // 私有构造函数
    private Order(Builder builder) {
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.address = builder.address;
        this.remark = builder.remark;
        this.couponCode = builder.couponCode;
    }

    // 静态入口方法（无参，必填参数通过链式调用设置，在 build() 中校验）
    public static Builder builder() {
        return new Builder();
    }

    // Builder 静态内部类
    public static class Builder {
        private String userId;            // 必填参数（build() 中校验）
        private String productId;         // 必填参数（build() 中校验）
        private int quantity = 1;
        private String address;
        private String remark;
        private String couponCode;

        // 链式方法：设置必填参数
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        // 链式方法：设置可选参数
        public Builder quantity(int quantity) { this.quantity = quantity; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public Builder remark(String remark) { this.remark = remark; return this; }
        public Builder couponCode(String couponCode) { this.couponCode = couponCode; return this; }

        public Order build() {
            // 在 build() 中校验必填参数，保证构建出的对象始终处于有效状态
            if (userId == null || userId.isEmpty()) {
                throw new IllegalStateException("userId 为必填参数，不能为空");
            }
            if (productId == null || productId.isEmpty()) {
                throw new IllegalStateException("productId 为必填参数，不能为空");
            }
            if (quantity <= 0) throw new IllegalArgumentException("数量必须大于0");
            return new Order(this);
        }
    }
}

// 客户端使用（链式调用，参数语义清晰）
Order order = Order.builder()
    .userId("user001")
    .productId("prod100")
    .quantity(3)
    .address("北京市海淀区")
    .couponCode("SAVE20")
    .build();
```

**💡 理解难点**:
1. **链式调用**: 如何设计流畅的API接口？
2. **必填参数**: 如何在编译期保证必填参数的设置？
3. **不可变对象**: 如何结合建造者模式创建不可变对象？
4. **参数校验**: 在哪个阶段进行参数校验最合适？

**🎯 业务应用场景**:
- **SQL查询构建**: 复杂SQL语句的动态构建
- **HTTP请求构建**: 包含多个可选参数的HTTP请求
- **配置对象**: 系统配置对象的创建，包含大量可选参数
- **产品定制**: 允许用户自定义配置的产品对象

### 5. 单例模式 ⭐⭐ (Singleton)

**📍 位置**: [`src/patterns/creational/singleton/package-info.java`](src/patterns/creational/singleton/package-info.java)

**模式说明**: 
确保一个类仅有一个实例，并提供一个访问它的全局访问点。

**代码结构分析**:
```java
// 推荐实现：静态内部类方式（懒加载 + 线程安全，无需加锁）
public class HolderSingleton {
    private HolderSingleton() {}

    // 静态内部类：只有首次调用 getInstance() 时才被加载
    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;  // JVM 保证类加载时的线程安全
    }
}

// 枚举方式（最安全，天然防反射和序列化攻击）
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("业务方法");
    }
}
```

**实现方式对比**:
- **饿汉式**: 类加载时初始化，线程安全但可能浪费内存
- **懒汉式（双重检查锁）**: 延迟初始化，使用 `volatile` + 双重检查保证线程安全
- **静态内部类**: ⭐ 推荐方式，结合了懒加载和线程安全，无需 synchronized
- **枚举**: ⭐⭐⭐ 最安全，天然防反射/序列化破坏，但无法懒加载

### 6. 原型模式 (Prototype)

**📍 位置**: [`src/patterns/creational/prototype/package-info.java`](src/patterns/creational/prototype/package-info.java)

**模式说明**: 
用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

**💡 理解难点**:
1. **浅拷贝 vs 深拷贝**: 何时使用浅拷贝？何时必须使用深拷贝？
2. **循环引用**: 深拷贝时如何处理对象间的循环引用？
3. **性能考量**: 拷贝 vs 重新创建的性能对比
4. **Cloneable接口**: Java中克隆机制的局限性

**🎯 业务应用场景**:
- **数据对象复制**: 复制复杂的业务对象避免重复初始化
- **配置模板**: 基于模板配置创建新的配置实例
- **游戏开发**: 复制游戏对象（怪物、道具）的属性和状态
- **文档系统**: 基于模板创建新文档

---

## 🔧 结构型模式 (Structural Patterns)

结构型模式关注类和对象的组合，通过组合获得更大的结构。

### 1. 适配器模式 ⭐ (Adapter)

**📍 位置**: [`src/patterns/structural/adapter/package-info.java`](src/patterns/structural/adapter/package-info.java)

**模式说明**: 
将一个类的接口转换成客户希望的另一个接口，使原本由于接口不兼容而不能一起工作的类可以一起工作。

**💡 理解难点**:
1. **对象适配器 vs 类适配器**: 组合和继承的选择
2. **接口适配**: 如何处理接口方法数量不匹配的情况？
3. **双向适配器**: 如何实现双向的接口转换？

**🎯 业务应用场景**:
- **第三方SDK集成**: 统一不同支付SDK的接口
- **数据格式转换**: XML与JSON数据格式的相互转换
- **遗留系统集成**: 新系统与旧系统的接口适配

### 2. 桥接模式 (Bridge)

**📍 位置**: [`src/patterns/structural/bridge/package-info.java`](src/patterns/structural/bridge/package-info.java)

**模式说明**: 
将抽象部分与实现部分分离，使它们都可以独立地变化。

**💡 理解难点**:
1. **抽象与实现的分离**: 如何识别哪些是抽象？哪些是实现？
2. **多维度变化**: 如何处理多个变化维度的组合？
3. **桥接 vs 策略**: 两种模式的区别和应用场景

**🎯 业务应用场景**:
- **图形绘制**: 图形抽象与绘制API的分离
- **消息发送**: 消息类型与发送渠道的分离
- **数据库操作**: 业务操作与数据库引擎的分离

### 3. 组合模式 (Composite)

**📍 位置**: [`src/patterns/structural/composite/package-info.java`](src/patterns/structural/composite/package-info.java)

**模式说明**: 
将对象组合成树形结构以表示"部分-整体"的层次结构，使用户对单个对象和组合对象的使用具有一致性。

**💡 理解难点**:
1. **透明组合 vs 安全组合**: 接口设计的权衡
2. **递归结构**: 如何正确处理树形结构的遍历？
3. **性能优化**: 大型组合结构的性能考虑

**🎯 业务应用场景**:
- **文件系统**: 文件和文件夹的统一处理
- **组织架构**: 部门和员工的层次结构
- **菜单系统**: 菜单项和子菜单的组合

### 4. 装饰模式 ⭐⭐ (Decorator)

**📍 位置**: [`src/patterns/structural/decorator/package-info.java`](src/patterns/structural/decorator/package-info.java)

**模式说明**: 
动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活。

**💡 理解难点**:
1. **装饰器链**: 多个装饰器的组合顺序
2. **透明性**: 装饰后对象与原对象的接口一致性
3. **装饰 vs 继承**: 何时使用装饰？何时使用继承？

**🎯 业务应用场景**:
- **IO流**: Java中的InputStream装饰器链
- **Web请求处理**: 请求的预处理和后处理
- **缓存装饰**: 为业务对象添加缓存功能

### 5. 代理模式 ⭐⭐⭐ (Proxy)

**📍 位置**: [`src/patterns/structural/proxy/package-info.java`](src/patterns/structural/proxy/package-info.java)

**模式说明**: 
为其他对象提供一种代理以控制对这个对象的访问。

**代码结构分析**:
```java
// 抽象主题接口
public interface OrderService {
    void placeOrder(String userId, String productId, int quantity);
    void cancelOrder(String orderId);
}

// 真实主题
public class OrderServiceImpl implements OrderService {
    @Override
    public void placeOrder(String userId, String productId, int quantity) {
        System.out.println("下单成功: 用户=" + userId + ", 商品=" + productId);
    }
    @Override
    public void cancelOrder(String orderId) {
        System.out.println("取消订单: " + orderId);
    }
}

// 静态代理（对象适配器方式：组合优于继承）
public class OrderServiceProxy implements OrderService {
    private final OrderService target;

    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void placeOrder(String userId, String productId, int quantity) {
        System.out.println("[权限检查] 用户 " + userId + " 可以下单");
        target.placeOrder(userId, productId, quantity);
        System.out.println("[日志记录] 下单操作已完成");
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("[权限检查] 需要管理员权限");
        // 模拟权限不足，拒绝操作
        System.out.println("[拒绝] 当前用户无取消订单权限");
    }
}
```

**💡 理解难点**:
1. **静态代理 vs 动态代理**: 编译期代理和运行期代理
2. **代理的透明性**: 客户端是否需要知道代理的存在？
3. **代理链**: 多层代理的设计和性能影响
4. **AOP实现**: 如何通过代理实现面向切面编程？

**🎯 业务应用场景**:
- **权限控制**: 在方法调用前进行权限验证
- **延迟加载**: 延迟初始化重量级对象
- **日志记录**: 记录方法调用的日志信息
- **事务管理**: 在业务方法前后处理事务

**代理类型**:
- **保护代理**: 控制对原对象的访问权限
- **虚拟代理**: 延迟创建开销大的对象
- **远程代理**: 为远程对象提供本地代理
- **智能引用**: 在访问对象时执行额外操作

#### JDK 动态代理

**📍 位置**: [`src/patterns/structural/proxy/jdk/DynamicProxyHandler.java`](src/patterns/structural/proxy/jdk/DynamicProxyHandler.java)

**模式说明**:
静态代理的痛点在于：每新增一个接口，就要手动编写对应的代理类。JDK 动态代理在运行时通过反射动态生成代理类，同一个 `InvocationHandler` 可以代理任意接口的所有方法。

**代码结构分析**:
```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 动态代理处理器：所有横切逻辑集中在此
public class DynamicProxyHandler implements InvocationHandler {
    private final Object realSubject;  // 被代理的真实对象（运行时传入）

    public DynamicProxyHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    // 代理对象的每个方法调用都会进入这里
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        // 前置处理：权限检查
        if ("cancelOrder".equals(methodName)) {
            String userId = (String) args[0];
            if (!userId.startsWith("admin")) {
                System.out.println("[动态代理] 权限不足，拒绝执行 " + methodName);
                return null;
            }
        }

        // 委托调用真实对象的方法
        Object result = method.invoke(realSubject, args);

        // 后置处理：日志记录
        System.out.println("[动态代理] " + methodName + " 执行完成，记录操作日志");
        return result;
    }

    // 创建动态代理对象的工厂方法
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object realSubject, Class<?>... interfaces) {
        return (T) Proxy.newProxyInstance(
            interfaces[0].getClassLoader(),
            interfaces,
            new DynamicProxyHandler(realSubject)
        );
    }
}

// 客户端使用：不需要编写 OrderServiceProxy 类
OrderServiceImpl realService = new OrderServiceImpl();
OrderService dynamicProxy = DynamicProxyHandler.createProxy(
    realService,
    OrderService.class
);
dynamicProxy.placeOrder("user001", "商品A", 2);   // 正常执行
dynamicProxy.cancelOrder("user002", "ORDER-001");  // 权限不足，拒绝
```

**💡 理解难点**:
1. **InvocationHandler**: 所有方法调用的入口，如何根据 method.getName() 分发逻辑？
2. **Proxy.newProxyInstance()**: 三个参数（类加载器、接口列表、回调处理器）各是什么作用？
3. **JDK 动态代理 vs CGLIB**: 有接口时用 JDK 代理，无接口时 CGLIB 通过子类化实现（Spring 自动选择）
4. **与 AOP 的关系**: Spring AOP 对接口默认使用 JDK 动态代理，对类默认使用 CGLIB

**🎯 业务应用场景**:
- **Spring AOP**: 事务管理、日志切面、权限控制的底层实现
- **MyBatis Mapper**: 动态生成 DAO 接口的实现类
- **RPC 框架**: 为远程接口生成本地代理，隐藏网络调用细节
- **框架设计**: 任何需要在方法调用前后插入横切逻辑的场景

### 6. 外观模式 (Facade)

**📍 位置**: [`src/patterns/structural/facade/package-info.java`](src/patterns/structural/facade/package-info.java)

**模式说明**: 
为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。

**💡 理解难点**:
1. **接口粒度**: 外观接口的抽象层次如何确定？
2. **子系统解耦**: 如何避免外观类变成God Class？
3. **分层外观**: 多层次外观的设计原则

**🎯 业务应用场景**:
- **API网关**: 为多个微服务提供统一入口
- **第三方库封装**: 简化复杂第三方库的使用
- **系统集成**: 整合多个子系统的功能

### 7. 享元模式 (Flyweight)

**📍 位置**: [`src/patterns/structural/flyweight/package-info.java`](src/patterns/structural/flyweight/package-info.java)

**模式说明**: 
运用共享技术有效地支持大量细粒度的对象。

**💡 理解难点**:
1. **内部状态 vs 外部状态**: 如何区分和设计状态？
2. **享元工厂**: 如何管理享元对象的生命周期？
3. **线程安全**: 共享对象的线程安全问题

**🎯 业务应用场景**:
- **字符渲染**: 文档编辑器中的字符对象共享
- **游戏开发**: 游戏中大量相似对象的管理
- **数据库连接**: 连接池中连接对象的复用

---

## 🎭 行为型模式 (Behavioral Patterns)

行为型模式关注对象之间的通信和职责分配。

### 1. 解释器模式 (Interpreter)

**📍 位置**: [`src/patterns/behavioral/interpreter/package-info.java`](src/patterns/behavioral/interpreter/package-info.java)

**模式说明**: 
给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。

**💡 理解难点**:
1. **文法设计**: 如何设计简洁而表达力强的文法？
2. **递归解释**: 复杂表达式的递归解释过程
3. **性能考虑**: 解释器的性能优化策略

**🎯 业务应用场景**:
- **配置文件解析**: 自定义配置语言的解析
- **表达式引擎**: 业务规则表达式的解释执行
- **SQL解析**: 简化版SQL语句的解析

### 2. 模板方法模式 ⭐ (Template Method)

**📍 位置**: [`src/patterns/behavioral/template_method/package-info.java`](src/patterns/behavioral/template_method/package-info.java)

**模式说明**: 
定义一个操作中的算法骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

**💡 理解难点**:
1. **钩子方法**: 可选步骤的设计和使用
2. **控制反转**: 父类调用子类方法的设计思想
3. **抽象层次**: 模板方法的抽象粒度控制

**🎯 业务应用场景**:
- **数据处理流程**: 数据导入、处理、导出的固定流程
- **测试框架**: 测试用例执行的标准流程
- **Web请求处理**: HTTP请求的标准处理流程

### 3. 责任链模式 ⭐⭐ (Chain of Responsibility)

**📍 位置**: [`src/patterns/behavioral/chain_of_responsibility/package-info.java`](src/patterns/behavioral/chain_of_responsibility/package-info.java)

**模式说明**: 
为请求创建了一个接收者对象的链，避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。

**💡 理解难点**:
1. **链的构建**: 如何动态构建和管理责任链？
2. **责任分配**: 如何合理分配各处理者的职责？
3. **性能优化**: 长链条的性能影响和优化

**🎯 业务应用场景**:
- **审批流程**: 多级审批的业务流程
- **异常处理**: 分层的异常处理机制
- **过滤器链**: Web过滤器的链式处理

### 4. 命令模式 ⭐ (Command)

**📍 位置**: [`src/patterns/behavioral/command/package-info.java`](src/patterns/behavioral/command/package-info.java)

**模式说明**: 
将一个请求封装为一个对象，从而可用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作。

**💡 理解难点**:
1. **命令封装**: 如何设计合适的命令接口？
2. **撤销操作**: 如何实现命令的撤销和重做？
3. **宏命令**: 复合命令的设计和执行

**🎯 业务应用场景**:
- **GUI操作**: 菜单项和工具栏按钮的命令封装
- **任务调度**: 后台任务的封装和调度
- **撤销重做**: 编辑器的撤销重做功能

### 5. 迭代器模式 (Iterator)

**📍 位置**: [`src/patterns/behavioral/iterator/package-info.java`](src/patterns/behavioral/iterator/package-info.java)

**模式说明**: 
提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。

**💡 理解难点**:
1. **内部迭代器 vs 外部迭代器**: 控制权的归属
2. **并发修改**: 迭代过程中集合被修改的处理
3. **多种遍历**: 支持多种遍历策略的设计

**🎯 业务应用场景**:
- **集合遍历**: 各种数据结构的统一遍历接口
- **数据库游标**: 大数据集的分页遍历
- **文件遍历**: 目录树的递归遍历

### 6. 中介者模式 (Mediator)

**📍 位置**: [`src/patterns/behavioral/mediator/package-info.java`](src/patterns/behavioral/mediator/package-info.java)

**模式说明**: 
定义一个中介对象来简化原有对象之间的交互关系。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

**💡 理解难点**:
1. **中介者复杂度**: 如何避免中介者变得过于复杂？
2. **通信协议**: 对象与中介者间的通信协议设计
3. **可复用性**: 中介者的可复用性考虑

**🎯 业务应用场景**:
- **聊天系统**: 聊天室中用户间的消息中转
- **MVC架构**: Controller作为View和Model的中介
- **工作流引擎**: 各个节点间交互的协调

### 7. 备忘录模式 (Memento)

**📍 位置**: [`src/patterns/behavioral/memento/package-info.java`](src/patterns/behavioral/memento/package-info.java)

**模式说明**: 
在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。

**💡 理解难点**:
1. **状态封装**: 如何保护备忘录的状态不被外部修改？
2. **内存管理**: 大量备忘录对象的内存管理
3. **增量备份**: 如何实现增量状态保存？

**🎯 业务应用场景**:
- **编辑器**: 文档编辑的撤销功能
- **游戏存档**: 游戏状态的保存和恢复
- **事务管理**: 事务回滚时的状态恢复

### 8. 观察者模式 ⭐⭐ (Observer)

**📍 位置**: [`src/patterns/behavioral/observer/package-info.java`](src/patterns/behavioral/observer/package-info.java)

**模式说明**: 
定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

**💡 理解难点**:
1. **推拉模型**: 推送数据 vs 拉取数据的设计选择
2. **观察者管理**: 观察者的注册、注销和通知顺序
3. **内存泄漏**: 观察者引用导致的内存泄漏问题
4. **线程安全**: 多线程环境下的观察者通知

**🎯 业务应用场景**:
- **事件系统**: GUI中的事件监听机制
- **数据绑定**: MVC/MVVM中的数据变化通知
- **消息推送**: 订阅-发布系统的实现

### 9. 状态模式 ⭐ (State)

**📍 位置**: [`src/patterns/behavioral/state/package-info.java`](src/patterns/behavioral/state/package-info.java)

**模式说明**: 
允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。

**💡 理解难点**:
1. **状态转换**: 状态间转换的控制和管理
2. **状态共享**: 状态对象是否应该共享？
3. **状态 vs 策略**: 两种模式的区别和适用场景

**🎯 业务应用场景**:
- **订单状态**: 订单的不同状态及其行为
- **游戏角色**: 角色的不同状态（攻击、防御、移动）
- **TCP连接**: 网络连接的状态管理

### 10. 策略模式 ⭐⭐⭐ (Strategy)

**📍 位置**: [`src/patterns/behavioral/strategy/package-info.java`](src/patterns/behavioral/strategy/package-info.java)

**模式说明**: 
定义一系列算法，把它们一个个封装起来，并且使它们可相互替换。

**代码结构分析**:
```java
// 策略接口：所有排序策略的公共约定
public interface SortStrategy {
    void sort(int[] array);
    String getName();  // 策略名称，用于展示
}

// 具体策略：冒泡排序
public class BubbleSortStrategy implements SortStrategy {
    @Override public void sort(int[] array) { /* 冒泡排序实现 */ }
    @Override public String getName() { return "冒泡排序"; }
}

// 具体策略：快速排序
public class QuickSortStrategy implements SortStrategy {
    @Override public void sort(int[] array) { /* 快速排序实现 */ }
    @Override public String getName() { return "快速排序"; }
}

// 具体策略：归并排序
public class MergeSortStrategy implements SortStrategy {
    @Override public void sort(int[] array) { /* 归并排序实现 */ }
    @Override public String getName() { return "归并排序"; }
}

// 上下文：持有策略引用，将请求委托给策略
public class ArraySorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {
        System.out.println("使用策略: " + strategy.getName());
        strategy.sort(array);
    }
}

// 客户端使用：切换策略无需修改 ArraySorter
ArraySorter sorter = new ArraySorter();
sorter.setStrategy(new QuickSortStrategy());
sorter.sort(new int[]{3, 1, 4, 1, 5});
```

**💡 理解难点**:
1. **策略选择**: 如何动态选择合适的策略？
2. **策略参数**: 策略需要额外参数时的设计
3. **策略组合**: 多个策略的组合使用
4. **函数式接口**: 现代Java中策略模式的简化实现

**🎯 业务应用场景**:
- **排序算法**: 根据数据量选择不同的排序策略
- **支付方式**: 不同的支付策略（支付宝、微信、银行卡）
- **压缩算法**: 根据文件类型选择压缩策略
- **缓存策略**: 不同的缓存淘汰策略（LRU、LFU、FIFO）

### 11. 访问者模式 (Visitor)

**📍 位置**: [`src/patterns/behavioral/visitor/package-info.java`](src/patterns/behavioral/visitor/package-info.java)

**模式说明**: 
表示一个作用于某对象结构中的各元素的操作，它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。

**💡 理解难点**:
1. **双分派**: 访问者模式的核心机制
2. **元素扩展**: 新增元素类型时的影响
3. **类型安全**: 编译时类型检查的保证
4. **性能考虑**: 双分派的性能开销

**🎯 业务应用场景**:
- **AST遍历**: 编译器中抽象语法树的遍历
- **文档处理**: 对不同类型文档元素的操作
- **报表生成**: 对不同数据结构的报表处理

---

## 🎯 设计模式最佳实践

### 选型决策：什么情况不该用

| 模式 | 常见误用 | 更好的替代 |
|------|---------|-----------|
| 单例 | 为了"全局只有一个"而套用，导致隐式依赖和测试困难 | 依赖注入容器管理单实例，显式传入 |
| 装饰器 | 层数超过 3 层，调试时追踪调用链困难 | 考虑责任链或直接组合核心逻辑 |
| 观察者 | 回调链中一个观察者抛出异常导致整条链路中断 | 每个观察者独立捕获异常，或改用消息队列解耦 |
| 代理 | 只做日志/权限等横切关注点，却在业务逻辑前后大量硬编码 | 改用 AOP 框架（如 Spring AOP）统一处理 |
| 工厂方法 | 产品类只有两三个，用 if-else 判断参数类型即可 | 直接用简单工厂或枚举映射，不要为了"扩展性"提前抽象 |

**核心原则**：当你发现自己在模式中写了越来越多的 `if-else`、大量的空方法、或者测试时 mock 异常困难——这是反模式的信号。

### 现代 Java 对模式的简化

- **函数式接口 + Lambda**：策略模式、回调模式不再需要单独的接口实现类，`Function<T, R>` 或自定义函数式接口直接传入 Lambda
- **Record 类型**：不可变的数据持有对象（如 DTO）用 `record` 替代传统类，减少样板代码
- **密封类 (sealed)**：Visitor 模式的元素类型可以用 `sealed interface` 声明，编译器确保 `switch` 表达式穷尽所有子类型

---

## 📖 学习路径

### 第一阶段：理解对象创建（单例、工厂、建造者）

从 `src/creational/` 目录入手。这三个模式的共同主题是**把 `new` 的时机和方式从客户端代码中抽离**。

推荐阅读顺序：
1. `singleton` — 理解为什么"全局唯一"不等于"线程安全"
2. `simple-factory` — 最直观的创建封装，建立"由谁来创建"的思维
3. `factory-method` — 学习"延迟到子类决定"的设计意图
4. `builder` — 掌握组合复杂对象时的可读性构建方式

### 第二阶段：理解结构组合（适配器、装饰器、代理）

从 `src/structural/` 目录入手。这三个模式处理的是**如何在对象之间建立灵活的关系**。

推荐阅读顺序：
1. `adapter` — 理解接口不兼容时的适配思路
2. `decorator` — 掌握"透明叠加功能"的能力
3. `proxy` — 学习在不修改原对象的前提下控制访问

### 第三阶段：理解行为传递（观察者、策略、命令、状态）

从 `src/behavioral/` 目录入手。这四个模式处理的是**如何让对象之间的交互松耦合**。

推荐阅读顺序：
1. `observer` — 理解事件驱动的基础
2. `strategy` — 掌握替换算法而不改动调用方的能力
3. `command` — 理解"请求"本身可以作为对象被存储、排队、撤销
4. `state` — 学习用状态对象替代条件分支，消除巨大的 `if-else`

### 深入建议

- **对比阅读**：`adapter` vs `decorator` vs `proxy` 都是结构型模式，但解决的问题完全不同——对比它们的类图能加深理解
- **框架溯源**：Spring 的 `BeanFactory` 是工厂方法的典型应用，`@Transactional` 是代理模式的应用，值得对照源码验证
- **实战练习**：在个人项目中有意识地识别模式适用场景，写完后回顾是否真正降低了耦合

---


## 🎓 总结

23 个设计模式围绕一个核心问题：**如何让代码在不修改已有代码的前提下支持变化**。

这条线索贯穿三大类模式：

- **创建型**回答"谁来创建"——把 `new` 的决策权转移出去
- **结构型**回答"谁来组合"——在对象之间建立灵活的链接关系
- **行为型**回答"谁来驱动"——让对象之间的协作松耦合

**最终的决策框架只有两步**：

> 1. 这个变化是**创建**层面的、**结构**层面的、还是**行为**层面的？
> 2. 引入模式增加的抽象层带来的收益，是否大于它带来的理解成本？

模式的价值不在于它本身有多巧妙，而在于它让你在需求变更时，只需要改动一处而不是全盘重写。**能让你安心睡觉的代码，才是好的设计模式应用。**

