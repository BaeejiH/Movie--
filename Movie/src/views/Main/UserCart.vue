<template>
  <div>
    <h1 class="display-1 text-center">장바구니</h1>
    <table class="table table-hover mt-3">
      <thead class="table-dark">
        <tr>
          <th>제목</th>
          <th>대여번호</th>
          <th>영화번호</th>
          <th>대여날짜</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="row in result" :key="row.movie_num">
          <td>{{ row.title }}</td>
          <td>{{ row.bcode }}</td>
          <td>{{ row.movie_num }}</td>
          <td>{{ row.borrowDate }}</td>
          <td>
            <button @click="removeFromCart(row.movie_num)" class="btn btn-danger">삭제</button>
          </td>
        </tr>
      </tbody>
    </table>
    <router-link to="/" class="btn btn-primary mt-3">영화 목록으로 돌아가기</router-link>
  </div>
</template>

<script>
import axios from "axios";
import store from "@/store";
import { mapGetters } from "vuex";

export default {
  name: "UserCart",
  data() {
    return {
      result: []
    }
  },
  computed: {
    ...mapGetters(["cartItems"]), // Vuex에서 장바구니 데이터 가져오기
  },
  created() {
    this.getBorrow()
    console.log(store)
  },
  methods: {
    removeFromCart(movie_num) {
      this.$store.commit("removeFromCart", movie_num); // Vuex에서 영화 삭제
    },

    getBorrow() {
      axios.post('http://localhost:8080/borrow')
        .then((response) => {
          this.result = response.data.result
        })
        .catch((error) => {
          console.log(error)
        })
    }
  },
};
</script>