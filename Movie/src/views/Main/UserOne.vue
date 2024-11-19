<template>
    <div  class="User-detail">
        <h1  class="title">사용자 상세정보</h1>
        <table  class="User-table">
            <tr>
                <th class="User-label">아이디</th>
                <td>{{userId}}</td>
            </tr>

            <tr>
                <th class="User-label">이름</th>
                <td>{{user.userName}}</td>
            </tr>

            <tr>
                <th class="User-label">이메일</th>
                <td>{{user.userEmail}}</td>
            </tr>

            <tr>
                <th class="User-label">성별</th>
                <td>{{user.gender}}</td>
            </tr>

            <tr>
                <th class="User-label">갱신날짜</th>
                <td>{{user.updateDate}}</td>
            </tr>

            <tr>
                <th class="User-label">가입날짜</th>
                <td>{{user.createDate}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
 name:'UserOne',
 data(){
    return{
        userId : this.$route.params.userId,
    }
 },
 computed: {
        ...mapState(['user']), // Vuex의 user 상태를 매핑
    },
    created() {
        this.$store.commit('setUserId',this.userId) // $store를 사용하면 vuex에 정의되어있는 상태,뮤테이션,행동등에 전역적으로 접근 가능. 
        this.$store.dispatch('fetchUser'); // 사용자 정보 요청, fetchUser를 호출하여 비동기 작업 수행
        console.log('user:'+this.userId)
    },

}
</script>

<style>
.User-detail {
    font-family: Arial, sans-serif;
    padding: 20px;
    background-color: #f8f8f8;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 900px;
    margin: 0 auto;
}

.title {
    font-size: 2em;
    font-weight: bold;
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

.User-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.User-table th, .User-table td {
    padding: 12px 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.User-table th {
    width: 120px;
    background-color: #f1f1f1;
    font-weight: 600;
    color: #555;
}

.User-table td {
    font-size: 1.1em;
    color: #333;
}

.User-label {
    font-weight: 600;
    color: #555;
}

.User-table tr:hover {
    background-color: #f9f9f9;
}
</style>