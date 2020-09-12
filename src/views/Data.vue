<template>
    <div>
        <!-- <div id="myChart2" :style="{width: '300px', height: '300px', float: 'left'}"></div>-->
        <el-table :data="tableData" border style="width: 100%">
            <el-table-column fixed prop="id" label="编号" width="100">
            </el-table-column>
            <!-- prop应该就是记号了-->
            <el-table-column
                    prop="timestamp"
                    label="时间"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="imsi"
                    label="人物编号"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="longitude"
                    label="精度"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="latitude"
                    label="纬度"
                    width="300">
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>

</template>

<script>
    let myChart = {}
    export default {
        data() {
            return {
                pageSize: '',
                total: '',
                tableData: [],
                cs:[]
            }
        },
        mounted(){
            //我们要在mounted生命周期函数中实例化echarts对象。因为我们要确保dom元素已经挂载到页面中
            this.drawZhu();
        },
        //生命周期函数
        created(){
            const that = this;
            axios.get('http://localhost:8081/people/findAll/0/10').then(function (resp) {
                console.log(resp);
                const dataset=0;
                // let cs=[];
                console.log(dataset);
                that.tableData = resp.data.content;
                that.pageSize = resp.data.size;
                that.total = resp.data.totalElements;
                // for(let i=0;i<7;i++){
                //     //获取经度，并将字符串转换为浮点类型
                //     cs.push(window.parseFloat(that.tableData[i].longitude))
                // }
                // that.cs = cs;
                // console.log("this is that.cs",that.cs)
            })
        },
        methods: {
            handleClick(row) {
                console.log(row);
            },
            page(currentPage) {
                const that = this;
                axios.get('http://localhost:8081/people/findAll/'+(currentPage-1)+'/10').then(function (resp) {
                    console.log(resp);
                    that.tableData = resp.data.content;
                    that.pageSize = resp.data.size;
                    that.total = resp.data.totalElements
                })
            },
            // drawZhu() {
            //     // 基于准备好的dom，初始化echarts实例
            //     const that = this
            //     // 这里必须axios获取接口，不然获取为空数组！！！
            //     axios.get('http://localhost:8081/people/findAll/0/10').then(function () {
            //         let myChart = that.$echarts.init(document.getElementById('myChart2'))
            //         const values = [100,123,342,546,7658,475,456];
            //         //放入到data中的对象,通过this就可以获取！！！
            //         console.log("here should be the data", that.cs)
            //         // 绘制图表
            //         myChart.setOption({
            //             xAxis: {
            //                 type: 'category',
            //                 data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            //             },
            //             yAxis: {
            //                 type: 'value'
            //             },
            //             series: [{
            //                 data: that.cs,
            //                 type: 'line',
            //                 smooth: true
            //             }]
            //         })
            //     })
            // },
        },
    }
</script>