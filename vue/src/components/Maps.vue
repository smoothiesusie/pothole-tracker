<!-- <template>
    <div id="map" style="height: 400px; width: 100%;"></div>
</template>

  <script>
  
  
  export default {
    name: 'Maps',
    mounted() {
      this.initMap();
    },


    methods: {
      async initMap() {
        const loader = new Loader({
          apiKey: "YOUR_API_KEY", 
          version: "weekly",
         
        });
  
        try {
          await loader.load();
          this.map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: -34.397, lng: 150.644 },
            zoom: 8,
          });
        } catch (error) {
          console.error("Error loading Google Maps:", error);
        }
      }
    }
  };
  </script>
  
  <style>
  #map {
    height: 100%;
  }
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
  </style> -->
 
 
 
<template>
  <div class="map-container">
    <GoogleMap api-key="AIzaSyBecan41m3EpaUjgHsf4QnYHDuuJ9HpZ_M" style="width: 100%; height: 500px" :center="center"
      :zoom="15">
      <MarkerCluster>
      <Marker v-for="marker in $store.state.markers" :position="marker.center" :key="marker.id"
        :options="{ position: marker.center }" />
      <!-- <Marker :options="{ position:test }" /> -->
    </MarkerCluster>
    </GoogleMap>
  </div>
</template>
  
<script>
import { defineComponent } from "vue";
import { GoogleMap, Marker, MarkerCluster} from "vue3-google-map";

export default defineComponent({
  components: { GoogleMap, Marker, MarkerCluster },
  props: {
    markers: Array,
  },
  computed: {
    test() {
      console.log(this.$store.state.potholes)
      console.log(this.$store.state.markers[0])
      let marker = { lat: parseInt(this.$store.state.markers[0].center.lat), lng: parseInt(this.$store.state.markers[0].center.lng) }
      console.log(marker)
      return marker;
    }

  },
  methods: {
    testCenter(marker) {
      return marker.center;
    }
  },

  setup() {
    const center = { lat: 39.952583, lng: -75.165222 };

    return { center };
  },
});
</script>

<style scoped>
.map-container {
  width: 80%;
  height: 500px;
  margin: auto;
  padding-bottom: 20px;

}

.pothole-pin {
  color: white;
}
</style>


