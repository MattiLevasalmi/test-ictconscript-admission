import Card from '@mui/material/Card';
import './entryCard.css';
import type { Entry } from '../types/entryType';

export default function EntryCard(props: Entry) {
  return (
    <Card className="entry-card">
      <section id="header">
        <h4>{props.title}</h4>
        <code>#{props.id}</code>
      </section>
      <section id="description">
        <p>{props.body}</p>
      </section>
      <section id="footer">
        <h5>{props.isoTime}</h5>
        {props.lat && props.lon ? (
          <button
            type="button"
            className="button"
            onClick={() => alert('A map will appear here!')}>
            {props.lat}° {props.lon}°
          </button>
        ) : (
          <></>
        )}
      </section>
    </Card>
  );
}
