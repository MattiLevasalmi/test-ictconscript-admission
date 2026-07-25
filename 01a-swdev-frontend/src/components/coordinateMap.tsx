import { type LatLngExpression } from 'leaflet';
import 'leaflet/dist/leaflet.css';
import './coordinateMap.css';
import { MapContainer, Marker, TileLayer, useMap } from 'react-leaflet';
import { useEffect } from 'react';

type CoordinateMapProps = {
  latitude?: number;
  longitude?: number;
  variant?: 'modal' | 'inline';
};

function MapController({
  position,
  zoom
}: {
  position: LatLngExpression;
  zoom: number;
}) {
  const map = useMap();

  useEffect(() => {
    map.setView(position, zoom);
    map.invalidateSize();
  }, [map, position, zoom]);

  return null;
}

export default function CoordinateMap(props: CoordinateMapProps) {
  const position: LatLngExpression = [
    props.latitude ?? 0,
    props.longitude ?? 0
  ];
  const zoom: number = 14;
  const mapClassName =
    props.variant === 'inline'
      ? 'coordinate-map-inline'
      : 'coordinate-map-modal';

  return (
    <MapContainer
      className={mapClassName}
      center={position}
      zoom={zoom}
      scrollWheelZoom={false}>
      <MapController position={position} zoom={zoom} />
      <TileLayer
        attribution="&copy; <a href='http://osm.org/copyright'>OpenStreetMap</a> contributors"
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      {props.latitude != undefined && props.longitude != undefined ? (
        <Marker
          position={[props.latitude, props.longitude]}
          title={`${props.latitude}° ${props.longitude}°`}
        />
      ) : (
        <></>
      )}
    </MapContainer>
  );
}
