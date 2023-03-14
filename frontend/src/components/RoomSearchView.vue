<template>

    <v-data-table
        :headers="headers"
        :items="roomSearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RoomSearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            roomSearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/roomSearches'))

            temp.data._embedded.roomSearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.roomSearch = temp.data._embedded.roomSearches;
        },
        methods: {
        }
    }
</script>

