<template>
    <div class="container mt-3">
        <h1 class="display-1 text-center">사용자 명단</h1>
        <table class="table table-hover mt-3">
            <thead class="table-dark">
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>성별</th>
                    <th>가입날짜</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="row in result" :key="row.userId">
                    <td>{{ row.userId }}</td>
                    <td>{{ row.userName }}</td>
                    <td>{{ row.userEmail }}</td>
                    <td>{{ row.gender }}</td>
                    <td>{{ row.createDate }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios';
import store from '@/store';
export default {
    name: 'UserLsit',
    data() {
        return {
            result: [],
        }
    },
    created() {
        this.getDB()
        console.log(store)
    },
    methods: {
        getDB() {
            axios
                .post('http://localhost:8080/user')
                .then((response) => {
                    console.log(response)
                    this.result = response.data.result
                })
                .catch((error) => {
                    console.log(error)
                })
        },
    }
}
</script>

<style></style>