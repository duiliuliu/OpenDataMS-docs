> 任务

- [ ] components
  - [ ] 公共组件
  - [ ] 新建任务
    - [ ] 公共组件--标签页组件
    - [ ] 新建采集任务页面组件
    - [ ] 新建清洗任务页面组件
    - [ ] 新建任务页面组件
- [ ] containers
  - [ ] 新建任务页面
    - [ ] 新建采集页面
    - [ ] 新建清洗页面
- [ ] redux/actions
  - [ ] 采集任务action
    - [ ] cityList 城市下拉菜单数据获取
      - [ ] REQUEST_CITY_LIST
      - [ ] LOAD_CITY_LIST
      - [ ] FETCH_CITY_LIST
    - [ ] dataList 数据项下拉菜单数据获取
      - [ ] REQUEST_DATA_LIST
      - [ ] LOAD_DATA_LIST
      - [ ] FETCH_DATA_LIST
    - [ ] download 下载数据至本地
    - [ ] submitJob
- [ ] redux/reducers
- [ ] redux/sagas

## components

任务整体分为采集任务与清洗任务，可抽象公共组件

- 标签页组件
  标签栏分为 采集任务 与 清洗任务

### 新建任务

![新建任务页面设计]()

可以从页面设计看出，新建任务需要组件

- 公共组件--标签页组件
- 新建采集任务页面组件
- 新建清洗任务页面组件
- 新建任务页面组件

## containers

- 新建采集任务页
- 新建清洗任务页面
- 新建任务页面

## redux/actions

- 请求数据action REQUEST_*
  ```
    {
        type: REQUEST_*,
        payload: param
    }
  ```

- 加载数据action LOAD_*
  ```
    {
        type: LOAD_*,
        payload: { data }
    }
  ```
- 提交数据action SUBMIT_*
  ```
    {
        type: SUBMIT_*,
        payload: { data }
    }
  ```
## redux/reducers