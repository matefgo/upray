export default function propsTransformer(props) {
    return {
        ...props,
        pagination: {
            ...props.pagination,
            initialDelta: 5,
            deltas: [
                    { label: 5 },
                    { label: 10 },
                    { label: 15 }
                ],
        }
    };
}