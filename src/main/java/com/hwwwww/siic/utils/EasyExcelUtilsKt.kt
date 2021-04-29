package com.hwwwww.siic.utils

import com.alibaba.excel.EasyExcel

import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy
import java.io.IOException
import java.io.OutputStream
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder
import javax.servlet.http.HttpServletResponse


open class EasyExcelUtilsKt {
    fun download(
        response: HttpServletResponse,
        fileName: String,
        headArray: Array<String>,
        listKey: Array<String>,
        dataList: List<Map<String, Any>>?
    ) {
        try {
            EasyExcel.write(outputStream(response, fileName)).head(head(headArray))
                .registerWriteHandler(LongestMatchColumnWidthStyleStrategy()).sheet()
                .doWrite(dataList(dataList, listKey))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    fun head(array: Array<String>): List<List<String>>? {
        val list: MutableList<List<String>> = ArrayList()
        for (s in array) {
            val head: MutableList<String> = ArrayList()
            head.add(s)
            list.add(head)
        }
        return list
    }

    @Throws(MalformedURLException::class)
    fun dataList(list: List<Map<String, Any>>?, listKey: Array<String>): List<List<Any>>? {
        val dataList: MutableList<List<Any>> = ArrayList()
        if (list != null) {
            for (map in list) {
                val data: MutableList<Any> = ArrayList()
                for (s in listKey) {
                    if (map[s] == null) {
                        data.add("")
                    } else {
                        //数据格式处理 发现包含showImg字段就展示网络图片（简单的判断）
                        //也可以根据自己的需求进行格式化操作都放在这里
                        val obj = map[s]
                        if (s.contains("showImg") && obj.toString().contains("http")) {
                            data.add(URL(obj.toString()))
                        } else {
                            data.add(obj.toString())
                        }
                    }
                }
                dataList.add(data)
            }
        }
        return dataList
    }

    @Throws(IOException::class)
    fun outputStream(response: HttpServletResponse, fileName: String): OutputStream? {

        response.contentType = "application/vnd.ms-excel"
        response.characterEncoding = "utf-8"
        //防止中文乱码
        response.setHeader("Content-Disposition", "attachment;filename=${URLEncoder.encode(fileName, "UTF-8")}.xlsx")
        return response.outputStream
    }
}